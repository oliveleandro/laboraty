package com.systemgo.laboratory.order;

import com.systemgo.laboratory.order.entity.Order;
import com.systemgo.laboratory.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(UUID id){
        Optional<Order> obj = repository.findById(id);
        return obj.get();
    }
}
