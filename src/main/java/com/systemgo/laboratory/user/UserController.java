package com.systemgo.laboratory.user;

import com.systemgo.laboratory.user.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(UUID.randomUUID(), "João", "joao@joao.com.br", "1599999999", "12345");
        return ResponseEntity.ok().body(user);
    }
}
