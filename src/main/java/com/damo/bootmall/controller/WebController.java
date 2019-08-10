package com.damo.bootmall.controller;


import com.damo.bootmall.bean.Product;
import com.damo.bootmall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/web")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    @Autowired
    ProductService productService;


    @RequestMapping
    public String index(ModelMap map) {
        logger.info("web controller - freemarker");
        map.put("title", "FIRST BLOOD");
        return "index";
    }

    @RequestMapping("/error")
    public String error() {
        throw new RuntimeException("test exception");
    }
    @RequestMapping("/product")
    public String product(ModelMap map) {
        List<Product> products = productService.tickAll();
        map.put("products", products);
        return "product";
    }

    @PostMapping("/product")
    public String addAndGetProduct(String name, Double price, ModelMap map) {

        Product newProduct = new Product();
        newProduct.setName(name);
        newProduct.setPrice(price);
        productService.createProduct(newProduct);

        List<Product> products = productService.tickAll();
        map.put("products", products);
        return "product";
    }

}
