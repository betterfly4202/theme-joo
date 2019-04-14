package com.themejoo.domain.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by betterfly
 * Date : 2019.04.15
 */

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public List<User> userList(){
        return userService.findAll();
    }

    @PostMapping("/user")
    public User create(@RequestBody User user){
        return userService.save(user);
    }


    @DeleteMapping("/user/{id}")
    public String delete(@PathVariable Long id){
        userService.delete(id);
        return "success";
    }
 }
