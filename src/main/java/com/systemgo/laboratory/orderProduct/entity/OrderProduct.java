package com.systemgo.laboratory.orderProduct.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.systemgo.laboratory.order.entity.Order;
import com.systemgo.laboratory.orderProduct.orderProductPK;
import com.systemgo.laboratory.product.entity.Product;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_product")
public class OrderProduct {

    @EmbeddedId
    private orderProductPK orderProductPk = new orderProductPK();
    private Integer quantity;
    private Double price;

    public OrderProduct() {
    }

    public OrderProduct(Order order, Product product, Integer quantity, Double price) {
        orderProductPk.setOrder(order);
        orderProductPk.setProduct(product);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getOrder() {
        return orderProductPk.getOrder();
    }

    public void setOrder(Order order) {
        orderProductPk.setOrder(order);
    }

    public Product getProduct() {
        return orderProductPk.getProduct();
    }

    public void setProduct(Product product) {
        orderProductPk.setProduct(product);
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Double getSubTotal() {
        return price * quantity;
    }
}
