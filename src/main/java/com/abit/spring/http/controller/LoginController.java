package com.abit.spring.http.controller;

import com.abit.spring.dto.LoginDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String loginPage() {
        System.out.println("get login");
        return "user/login";
    }

    @PostMapping
    public String login(Model model, @ModelAttribute("login") LoginDto loginDto, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("login", loginDto);
        System.out.println("post login");
        return "redirect:/login";
    }
}