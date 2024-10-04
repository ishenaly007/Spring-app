package com.abit.spring.http.rest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequestMapping("/api/v1/message")
public class MessageRestController {

    private final MessageSource messageSource;

    public MessageRestController(@Qualifier("messageSource") MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String getMessage(@RequestParam String key, @RequestParam("lang") String language) {
        return messageSource.getMessage(key, null, null, new Locale(language));
    }
}