package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

//    list users show id by item and page, example if set item to 10 it will show 1-10 item
//    It just test if the query works or not, no applied real logic yet.
    @GetMapping("/users")
    public List<UsersResponse> getAllUser(@RequestParam(required = false, defaultValue ="2") int page, @RequestParam(required = false, defaultValue = "15") int item){
        List<UsersResponse> users = new ArrayList<>();
        for(int i=1;i<=item;i++){
            users.add(new UsersResponse(i, "User "+i+", page: "+page));
        }
        return users;
    }

    @GetMapping("/users/{id}")
    public UsersResponse getUserById(@PathVariable int id){
        return new UsersResponse(id, "User "+id);
    }
}
