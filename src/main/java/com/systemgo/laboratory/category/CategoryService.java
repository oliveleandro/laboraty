package com.systemgo.laboratory.category;

import com.systemgo.laboratory.category.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(UUID id){
        Optional<Category> obj = repository.findById(id);
        return obj.get();
    }
}
