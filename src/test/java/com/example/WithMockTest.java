package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
class WithMockTest {

    @Inject
    SomethingThatNeedsToCreateBarRuntime somethingThatNeedsToCreateBarRuntime;

    @Test
    void withMockItReturnsFake() {
        final Bar bar = somethingThatNeedsToCreateBarRuntime.createBar();
        assertEquals("fake", bar.getRealOrFake());
    }

    @MockBean(Bar.class)
    Bar fakeBar() {
        return new Bar("fake");
    }
}
