package com.systemgo.laboratory.category.entity;

import com.systemgo.laboratory.product.entity.Product;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue
    private UUID categoryId;
    private String name;

    @Transient
    private Set<Product> products = new HashSet<>();

    public Category(){
    }

    public Category(UUID categoryId, String name) {
        this.categoryId = categoryId;
        this.name = name;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }
}
