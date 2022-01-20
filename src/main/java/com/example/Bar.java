package com.example;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Prototype;

@Prototype
public class Bar {

    public Bar() {
    }

    public String getRealOrFake() {
        return "real";
    }
}
