package com.products.products.controller;

import com.products.products.domain.Product;
import com.products.products.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "product")
public class ProductController {

    private Logger log = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;


    @GetMapping(value = "/products")
    public List<Product> getProducts() {
        log.info("Received request to fetch all products");
        List<Product> products = productService.getProducts();
        log.info("products size = {}", products.size());
        return products;
    }

    @GetMapping(value = "/product/{productId}")
    public Optional<Product> getProduct(@PathVariable String productId) {
        Product product = null;
        log.info("Received request to get the product for ID = {}", productId);
        try {
            product = productService.getProduct(Long.valueOf(productId));
        } catch (Exception e ){
            log.error("Exception encountered " ,e.getStackTrace());
        }
      return Optional.ofNullable(product);
    }

}
