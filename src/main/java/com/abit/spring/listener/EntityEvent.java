package com.abit.spring.listener;

import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;
@ToString
@Getter
public class EntityEvent extends ApplicationEvent {
    public MyAccessType myAccessType;

    public EntityEvent(Object source, MyAccessType accessType) {
        super(source);
        this.myAccessType = accessType;
    }

}