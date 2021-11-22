package uz.developer.appwerehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.payload.UserDto;
import uz.developer.appwerehouse.service.UserService;

import java.util.List;

@RestController

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public Result getAllUser() {
        return userService.getAllUser();

    }

    @GetMapping("/{id}")
    public Result getUser(@PathVariable Integer id) {
        return userService.getOneUser(id);
    }

    @DeleteMapping("/{id}")
    public Result deleteUser(@PathVariable Integer id) {
        return userService.deleteUser(id);
    }

    @PutMapping("/{id}")
    public Result editUser(@PathVariable Integer id, @RequestBody UserDto userDto) {
        return userService.editUser(id, userDto);
    }

    @PostMapping("/adduser")
    public Result addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }
}
