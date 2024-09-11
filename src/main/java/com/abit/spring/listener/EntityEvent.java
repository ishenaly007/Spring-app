package com.abit.spring.listener;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class EntityEvent extends ApplicationEvent {
    public MyAccessType myAccessType;

    public EntityEvent(Object source, MyAccessType accessType) {
        super(source);
        this.myAccessType = accessType;
    }
}