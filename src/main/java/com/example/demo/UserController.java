package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/users")
    public UsersResponse createNewUser(@RequestBody NewUserRequest request){
//        Validate input
//        Create user into database
        User user = new User();
        user.setName(request.getName());
        user.setAge(request.getAge());
        user = userRepository.save(user);
        return new UsersResponse(user.getId(),user.getName()+user.getAge());
    }

//    list users show id by item and page, example if set item to 10 it will show 1-10 item
//    It just test if the query works or not, no applied real logic yet.
    @GetMapping("/users")
    public PagingResponse getAllUser(@RequestParam(defaultValue ="1") int page, @RequestParam(name="item_per_page",defaultValue = "10") int itemPerPage){
        PagingResponse pr = new PagingResponse(page, itemPerPage);
        List<UsersResponse> usersResponseList = new ArrayList<>();

        Iterable<User> users = userRepository.findAll();
        for(User user: users){
            usersResponseList.add(new UsersResponse(user.getId(),user.getName()));
        }

        pr.setUsers(usersResponseList);
        return pr;
    }

    @GetMapping("/users/{id}")
    public UsersResponse getUserById(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);
        return new UsersResponse(user.get().getId(), user.get().getName());
    }

}
