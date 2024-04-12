package com.example.mydreamgardenbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mydreamgardenbackend.model.Order;
import com.example.mydreamgardenbackend.repository.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo orderRepo;

    //post or create
    public Order createOrder(Order order)
    {
        return orderRepo.save(order);
    }

    //get
    public List<Order> getOrders()
    {
        return orderRepo.findAll();
    }
    //get by id
    public Order getOrderById(int id)
    {
        return orderRepo.findById(id).orElse(null);
    }

    //update or put
    public boolean updateOrder(int Id,Order order)
    {
        if(this.getOrderById(Id)==null)
        {
            return false;
        }
        try{
            orderRepo.save(order);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    //delete
    public boolean deleteOrder(int Id)
    {
        if(this.getOrderById(Id)==null)
        {
            return false;
        }
        orderRepo.deleteById(Id);
        return true;
    }

    //sorting by field
    public List<Order> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return orderRepo.findAll(sort);
    }

    //pagination
    public List<Order> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return orderRepo.findAll(page).getContent();
    }

    //sorting and pagination
    public List<Order> getsort(int pageNumber,int pageSize,String field)
    {          return orderRepo.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}
