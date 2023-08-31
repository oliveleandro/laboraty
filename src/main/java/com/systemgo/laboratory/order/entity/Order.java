package com.systemgo.laboratory.order.entity;

import com.systemgo.laboratory.user.entity.User;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue
    private UUID orderId;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private User client;

    public Order(){
    }

    public Order(UUID orderId, Instant moment, User client) {
        this.orderId = orderId;
        this.moment = moment;
        this.client = client;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public Instant getMoment() {
        return moment;
    }

    public User getClient() {
        return client;
    }
}
