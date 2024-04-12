package com.example.mydreamgardenbackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.mydreamgardenbackend.model.Products;
import com.example.mydreamgardenbackend.repository.ProductsRepo;

@Service
public class ProductsService {
    @Autowired
    ProductsRepo productsRepo;

    //post or create
    public Products createProducts(Products products)
    {
        return productsRepo.save(products);
    }

    //get
    public List<Products> getProducts()
    {
        return productsRepo.findAll();
    }
    //get by id
    public Products getProductById(int Id)
    {
        return productsRepo.findById(Id).orElse(null);
    }

    //update or put
    public boolean updateProducts(int Id,Products products)
    {
        if(this.getProductById(Id)==null)
        {
            return false;
        }
        try{
            productsRepo.save(products);
        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }

    //delete
    public boolean deleteProducts(int Id)
    {
        if(this.getProductById(Id)==null)
        {
            return false;
        }
        productsRepo.deleteById(Id);
        return true;
    }

    //sorting by field
    public List<Products> sort(String field)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,field);
        return productsRepo.findAll(sort);
    }

    //pagination
    public List<Products> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return productsRepo.findAll(page).getContent();
    }

    //sorting and pagination
    public List<Products> getsort(int pageNumber,int pageSize,String field)
    {          return productsRepo.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,field))).getContent();
    }
}
