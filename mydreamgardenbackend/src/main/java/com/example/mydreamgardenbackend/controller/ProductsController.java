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

import com.example.mydreamgardenbackend.model.Products;
import com.example.mydreamgardenbackend.service.ProductsService;

@RestController
public class ProductsController {
    @Autowired
    ProductsService productsService;

    //post
    @PostMapping("/addproducts")
    public ResponseEntity<Products> addProducts( @RequestBody Products products)
    {
        Products prod=productsService.createProducts(products);
        return new ResponseEntity<>(prod,HttpStatus.CREATED);
    }

    //get
    @GetMapping("/getproducts")
    public ResponseEntity<java.util.List<Products>> showProducts()
    {
        return new ResponseEntity<>(productsService.getProducts(),HttpStatus.OK);
    }

    
    //put
    @PutMapping("/putproducts/{Id}")
    public ResponseEntity<Products> updateLogin(@PathVariable("Id") int Id,@RequestBody Products products )
    {   
        if(productsService.updateProducts(Id, products)==true)
        {

            return new ResponseEntity<>(products,HttpStatus.OK);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/deleteproducts/{Id}")
    public ResponseEntity<Boolean> deleteLogin(@PathVariable("Id") int Id)
    {
        if(productsService.deleteProducts(Id)==true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
    //sorting
    @GetMapping("/products/sortBy/{field}")
    public List<Products> g(@PathVariable String field)
    {
        return productsService.sort(field);
    }

    //pagination
    @GetMapping("/products/{offset}/{pagesize}")
    public List<Products> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return productsService.page(pagesize, offset);
    }
    
    //sorting and pagination
    @GetMapping("/products/{offset}/{pagesize}/{field}")
    public List<Products> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
        return productsService.getsort(offset,pagesize,field);
    }
}
