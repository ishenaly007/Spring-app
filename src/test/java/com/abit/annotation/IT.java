package com.abit.annotation;

import com.abit.integration.TestApplicationRunner;
import com.abit.spring.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@ActiveProfiles("test")
@SpringBootTest(classes = {TestApplicationRunner.class, ApplicationRunner.class})
public @interface IT {
}