package com.abit.spring.http.controller;

import com.abit.spring.dto.PageResponse;
import com.abit.spring.dto.UserCreateEditDto;
import com.abit.spring.dto.UserFilter;
import com.abit.spring.dto.UserReadDto;
import com.abit.spring.entity.Role;
import com.abit.spring.service.CompanyService;
import com.abit.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping
    public String findAllUsers(Model model, UserFilter filter, Pageable pageable) {
//        model.addAttribute("users", userService.findAllUsers());
        Page<UserReadDto> page = userService.findAllUsers(filter, pageable);
        model.addAttribute("users", PageResponse.of(page));
        model.addAttribute("filter", filter);
        return "user/users";
    }

    @GetMapping("/registration")
    public String registration(Model model, @ModelAttribute UserCreateEditDto user) {
        if (!model.containsAttribute("user")) {
            model.addAttribute("user", user); // добавляем новую форму, если она не была передана через flash
        }
        model.addAttribute("roles", Role.values());
        model.addAttribute("companies", companyService.findAll());
        return "user/registration";
    }

    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/{id}")
    public String findUserById(@PathVariable("id") Integer id, Model model,
                               @CurrentSecurityContext SecurityContext securityContext,
                               @AuthenticationPrincipal UserDetails userDetails //чаще используется вот это чем целый контекст
    ) {
        return userService.findUserById(id)
                .map(user -> {
                    model.addAttribute("user", user);
                    model.addAttribute("roles", Role.values());
                    model.addAttribute("companies", companyService.findAll());
                    return "user/user";
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public String createUser(@ModelAttribute @Validated UserCreateEditDto user,
                             BindingResult bindingResult,
                             RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("user", user);
            redirectAttributes.addFlashAttribute("errors", bindingResult.getAllErrors());
            return "redirect:/users/registration";
        }
        UserReadDto dto = userService.createUser(user);
        return "redirect:/users/" + dto.getId();
    }

    //    @PutMapping("/{id}")
    @PostMapping("/{id}/update")
    public String updateUser(@PathVariable("id") Integer id, @ModelAttribute @Validated UserCreateEditDto user) {
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