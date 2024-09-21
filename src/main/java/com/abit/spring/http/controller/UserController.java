package com.abit.spring.http.controller;

import com.abit.spring.dto.UserCreateEditDto;
import com.abit.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public String findAllUsers(Model model) {
//        model.addAttribute("users" , userService.findAll());
//        model.addAttribute("users" , userService.findAll(filter));
        return "user/users";
    }

    @GetMapping("/{id}")
    public String findUserById(@PathVariable("id") Integer id, Model model) {
//        model.addAttribute("user", userService.findById());
        return "user/user";
    }

    @PostMapping
    public String createUser(@ModelAttribute("user") UserCreateEditDto user) {
//        userService.createUser(user);
        return "redirect:/users" + 25;
    }

    //    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Integer id, @ModelAttribute UserCreateEditDto user) {
//        userService.updateUser(id);
        return "redirect:/users/{id}";
    }

//    @DeleteMapping("/{id}")
    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
//        userService.deleteUser(id);
        return "redirect:/users";
    }
}