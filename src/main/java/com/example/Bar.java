package com.example;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class Bar {

    private final String realOrFake;

    public Bar(@Parameter String realOrFake) {
        this.realOrFake = realOrFake;
    }

    public String getRealOrFake() {
        return realOrFake;
    }
}
