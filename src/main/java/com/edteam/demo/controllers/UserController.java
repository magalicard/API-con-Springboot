package com.edteam.demo.controllers;

import com.edteam.demo.models.User;
import com.edteam.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<User> getAll() {
        return userService.getAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    User get(@PathVariable long id) {
        return userService.get(id);
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    void register(@RequestBody User user) {
        userService.register(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    User update(@RequestBody User user) {
        return userService.update(user);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable long id) {
        userService.delete(id);
    }

}

