package com.systemgo.laboratory.user;

import com.systemgo.laboratory.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findById(UUID id){
        Optional<User> obj = repository.findById(id);
        return obj.get();
    }
}
