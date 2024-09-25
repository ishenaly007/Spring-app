package com.abit.spring.http.controller;

import com.abit.spring.dto.UserCreateEditDto;
import com.abit.spring.dto.UserReadDto;
import com.abit.spring.entity.Role;
import com.abit.spring.service.CompanyService;
import com.abit.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public String findAllUsers(Model model) {
        model.addAttribute("users", userService.findAllUsers());
//        model.addAttribute("users" , userService.findAll(filter));
        return "user/users";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute("user") UserCreateEditDto user) {
        model.addAttribute("user", user);
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }

    @GetMapping("/{id}")
    public String findUserById(@PathVariable("id") Integer id, Model model) {
        return userService.findUserById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("companies", companyService.findAll());
                    return "user/user";
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String createUser(@ModelAttribute UserCreateEditDto user, RedirectAttributes redirectAttributes) {
        if (true) {
//            redirectAttributes.addAttribute("username", user.getUsername());
//            redirectAttributes.addAttribute("firstname", user.getFirstname());
            redirectAttributes.addFlashAttribute("user", user);
            return "redirect:/users/registration";
        }
        UserReadDto dto = userService.createUser(user);
        return "redirect:/users/" + dto.getId();
    }

    //    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Integer id, @ModelAttribute UserCreateEditDto user) {
        return userService.updateUser(id, user)
                .map(user1 -> "redirect:/users/{id}")
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    //    @DeleteMapping("/{id}")
    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Integer id) {
        if (!userService.deleteUser(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            return "redirect:/users";
        }
    }
}