package com.abit.spring.http.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "com.abit.spring.http.rest")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {
}
