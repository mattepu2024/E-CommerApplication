package com.products.products.service;

import com.products.products.domain.Product;
import com.products.products.entities.ProductEntity;
import com.products.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProducts() {
        List<ProductEntity> entities = productRepository.findAll();
        return convert(entities);
    }

    public Product getProduct(Long productId) {
        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        return convert(productEntity);
    }

    private Product convert(Optional<ProductEntity> productEntity) {
        Product product = new Product();
        if (productEntity.isPresent()) {
            product.setID(productEntity.get().getID());
            product.setName(productEntity.get().getName());
            product.setDescription(productEntity.get().getDescription());
            product.setPrice(productEntity.get().getPrice());
            product.setImageURL(productEntity.get().getImageURL());
        } else {
            throw new RuntimeException("Product does not find for given id ");
        }


        return product;


    }

    private List<Product> convert(List<ProductEntity> productEntities) {
        List<Product> products = new ArrayList<>();
        for (ProductEntity entity : productEntities) {
            Product product = new Product();
            product.setID(entity.getID());
            product.setDescription(entity.getDescription());
            product.setName(entity.getName());
            product.setPrice(entity.getPrice());
            product.setImageURL(entity.getImageURL());
            products.add(product);
        }
        return products;
    }

}
