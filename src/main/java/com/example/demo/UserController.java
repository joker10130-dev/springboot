package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    @ResponseBody
    public List<UsersResponse> getAllUser(@RequestParam(required = false, defaultValue ="2") int page, @RequestParam(required = false, defaultValue = "15") int item){
        List<UsersResponse> users = new ArrayList<>();
        users.add(new UsersResponse(1, "User 1"));
        users.add(new UsersResponse(2, "User 2"));
        users.add(new UsersResponse(3, "User 3"));
        return users;
    }

//    http://localhost:8080/test?page=5&item=20
    @GetMapping("/test")
    @ResponseBody
    public String getTest(@RequestParam(required = false, defaultValue ="2") int page, @RequestParam(required = false, defaultValue = "15") int item){
        return "page "+page+", and "+ item+" item per page";
    }

    @GetMapping("/users/{id}")
    public UsersResponse getUserById(@PathVariable int id){
        return new UsersResponse(id, "User "+id);
    }
}
