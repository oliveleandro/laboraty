package com.systemgo.laboratory.order.entity;

import com.systemgo.laboratory.order.enums.OrderStatus;
import com.systemgo.laboratory.orderProduct.entity.OrderProduct;
import com.systemgo.laboratory.user.entity.User;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue
    private UUID orderId;
    private Instant moment;

    private Integer orderStatus;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    @OneToMany(mappedBy = "orderProductPk.order")
    private Set<OrderProduct> items = new HashSet<>();

    public Order(){
    }

    public Order(UUID orderId, Instant moment, OrderStatus orderStatus, User client) {
        this.orderId = orderId;
        this.moment = moment;
        setOrderStatus(orderStatus);
        this.client = client;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public Instant getMoment() {
        return moment;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(orderStatus);
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null) {
            this.orderStatus = orderStatus.getCode();
        }
    }

    public User getClient() {
        return client;
    }

    public Set<OrderProduct> getItems() {
        return items;
    }

    public Double getTotal() {
        double sum = 0.0;
        for (OrderProduct x : items) {
            sum += x.getSubTotal();
        }
        return sum;
    }
}
