package com.systemgo.laboratory.product.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.systemgo.laboratory.category.entity.Category;
import com.systemgo.laboratory.order.entity.Order;
import com.systemgo.laboratory.orderProduct.entity.OrderProduct;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_product")
public class Product {

    @Id
    @GeneratedValue
    private UUID productId;
    private String name;
    private String description;
    private Double price;
    private String imgUrl;

    // Utilizado o Set pois não pode haver um produto com mais de uma categoria
    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @OneToMany(mappedBy = "orderProductPk.product")
    private Set<OrderProduct> items = new HashSet<>();

    private Product(){
    }

    public Product(UUID productId, String name, String description, Double price, String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public UUID getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<Order> getOrders() {
        Set<Order> set = new HashSet<>();
        for (OrderProduct x : items) {
            set.add(x.getOrder());
        }
        return set;
    }
}
