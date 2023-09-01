package com.systemgo.laboratory.product;

import com.systemgo.laboratory.product.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(UUID id){
        Optional<Product> obj = repository.findById(id);
        return obj.get();
    }
}
