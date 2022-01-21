package com.example;

import io.micronaut.context.BeanContext;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class SomethingThatNeedsToCreateBarRuntime {

    @Inject
    BeanContext beanContext;

    @Inject
    Bar directInject;

    Bar createBar() {
        return beanContext.createBean(Bar.class);
    }
}
