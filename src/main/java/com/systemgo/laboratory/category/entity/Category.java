package com.systemgo.laboratory.category.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;
@Entity
@Table(name = "tb_category")
public class Category {

    @Id
    @GeneratedValue
    private UUID categoryId;
    private String name;

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
}
