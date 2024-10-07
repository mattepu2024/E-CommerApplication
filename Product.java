package com.products.products.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    Long ID;
    String name;
    String description;
    Double price;
    String imageURL;
}
