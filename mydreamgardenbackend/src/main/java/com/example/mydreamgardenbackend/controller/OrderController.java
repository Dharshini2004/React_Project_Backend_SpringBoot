package com.example.mydreamgardenbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mydreamgardenbackend.model.Order;
import com.example.mydreamgardenbackend.service.OrderService;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

     //post
     @PostMapping("/addorder")
     public ResponseEntity<Order> addOrder( @RequestBody Order order)
     {
         Order order2=orderService.createOrder(order);
         return new ResponseEntity<>(order2,HttpStatus.CREATED);
     }
 
     //get
     @GetMapping("/getorder")
     public ResponseEntity<java.util.List<Order>> showProducts()
     {
         return new ResponseEntity<>(orderService.getOrders(),HttpStatus.OK);
     }
 
     
     //put
     @PutMapping("/putorder/{Id}")
     public ResponseEntity<Order> updateLogin(@PathVariable("Id") int Id,@RequestBody Order order)
     {   
         if(orderService.updateOrder(Id, order)==true)
         {
 
             return new ResponseEntity<>(order,HttpStatus.OK);
         }
         return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
     }
 
     //DELETE
     @DeleteMapping("/deleteorder/{Id}")
     public ResponseEntity<Boolean> deleteLogin(@PathVariable("Id") int Id)
     {
         if(orderService.deleteOrder(Id)==true)
         {
             return new ResponseEntity<>(true,HttpStatus.OK);
         }
         return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
     }
 
     //sorting
     @GetMapping("/order/sortBy/{field}")
     public List<Order> g(@PathVariable String field)
     {
         return orderService.sort(field);
     }
 
     //pagination
     @GetMapping("/order/{offset}/{pagesize}")
     public List<Order> get(@PathVariable int offset,@PathVariable int pagesize)
     {
         return orderService.page(pagesize, offset);
     }
     
     //sorting and pagination
     @GetMapping("/order/{offset}/{pagesize}/{field}")
     public List<Order> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
     {
        return orderService.getsort(offset,pagesize,field);
     }

}
