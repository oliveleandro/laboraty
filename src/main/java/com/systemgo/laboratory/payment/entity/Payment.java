package com.systemgo.laboratory.payment.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.systemgo.laboratory.order.entity.Order;
import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "tb_payment")
public class Payment {

    @Id
    @GeneratedValue
    private UUID paymentId;
    private Instant moment;
    @JsonIgnore
    @OneToOne
    @MapsId
    private Order order;

    public Payment(){
    }

    public Payment(UUID paymentId, Instant moment, Order order) {
        this.paymentId = paymentId;
        this.moment = moment;
        this.order = order;
    }

    public UUID getPaymentId() {
        return paymentId;
    }

    public Instant getMoment() {
        return moment;
    }
}
