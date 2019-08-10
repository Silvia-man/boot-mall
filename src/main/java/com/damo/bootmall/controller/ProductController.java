package com.damo.bootmall.controller;


import com.damo.bootmall.bean.Product;
import com.damo.bootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService service;

    //jdbc
    @PostMapping
    public int addProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @GetMapping("/{name}")
    public Product getProductByName (@PathVariable String name) {
        return service.getByName(name);
    }


    //jpa
    @GetMapping("/all")
    public List<Product> getAllProducts() {
        return service.tickAll();
    }

    @GetMapping("/id/{id}")
    public Product getById(@PathVariable int id) {
       // return service.getById(id);
        return service.tickById(id);
    }

    @GetMapping("/{name}/{price}")
    public Product getByNameAndPrice (@PathVariable String name,@PathVariable Double price) {
        return service.tickByNameAndPrice(name, price);
    }

    @PutMapping("/{id}")
    public Product renewProduct(@PathVariable int id, @RequestBody Product product) {
        product.setId(id);
        return service.renewProduct(product);
    }
    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable int id) {
        return service.removeProduct(id);
    }
}
