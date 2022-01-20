package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

@MicronautTest
class WithoutMockTest {

    @Inject
    SomethingThatNeedsToCreateBarRuntime somethingThatNeedsToCreateBarRuntime;

    @Test
    void withoutMockItReturnsDefaultBean() {
        final Bar bar = somethingThatNeedsToCreateBarRuntime.createBar();
        Assertions.assertEquals("real", bar.getRealOrFake());
    }

    @Test
    void createdBarIsNotSingleton(){
        final Bar bar1 = somethingThatNeedsToCreateBarRuntime.createBar();
        final Bar bar2 = somethingThatNeedsToCreateBarRuntime.createBar();
        Assertions.assertNotSame(bar1, bar2);
    }

}
