package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/users")
    public UsersResponse[] getAllUser(){
        UsersResponse[] u = new UsersResponse[2];
        u[0] = new UsersResponse(1, "User 1");
        u[1] = new UsersResponse(2, "User 2");
        return u;
    }
}
