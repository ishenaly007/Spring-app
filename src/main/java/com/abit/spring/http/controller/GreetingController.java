package com.abit.spring.http.controller;

import com.abit.spring.dto.ProductReadDto;
import com.abit.spring.dto.UserReadDto;
import com.abit.spring.entity.Role;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("api/v1")
@SessionAttributes({"user"})
public class GreetingController {

    @ModelAttribute("roles")
    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }//вызывается перед каждым запросом

    @GetMapping("/hello/{id}")
    public ModelAndView hello(ModelAndView mv,
                              HttpServletRequest request,
                              @RequestParam("age") Integer age,
                              @RequestHeader("accept") String accept,
                              @CookieValue("JSESSIONID") String jsessionid,
                              @PathVariable("id") Integer id,
                              Model model,
                              ProductReadDto productReadDto //этого через url будем добавлять типа: &id=1&name=Lenovo
    ) {
        mv.setViewName("greeting/hello");
        //model.addAttribute("user", new UserReadDto(1L, "Andrei"));
        model.addAttribute("product", productReadDto);
        return mv;
    }

    @GetMapping("/bye")
    public String bye(@SessionAttribute("user") UserReadDto user) {
        return "greeting/bye";
    }
}