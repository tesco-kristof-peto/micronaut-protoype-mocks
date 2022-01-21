package com.example;

import io.micronaut.context.annotation.Parameter;
import io.micronaut.context.annotation.Prototype;

@Prototype
class Bar {

    Bar() {
    }

    String getRealOrFake() {
        return "real";
    }
}
