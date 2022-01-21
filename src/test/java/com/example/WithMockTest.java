package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import io.micronaut.context.BeanContext;
import io.micronaut.context.annotation.Primary;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest(rebuildContext = true)
class WithMockTest {

    @Inject
    SomethingThatNeedsToCreateBarRuntime somethingThatNeedsToCreateBarRuntime;

    @Inject
    Bar barDirectInject;

    @Inject
    BeanContext context;

    @Test
    void withMockItReturnsFake() {
        final Bar bar = somethingThatNeedsToCreateBarRuntime.createBar();
        assertEquals("fake", bar.getRealOrFake());
    }

    @Test
    void injectItDirectlyToSomethingReturnsFake() {
        assertEquals("fake", somethingThatNeedsToCreateBarRuntime.directInject.getRealOrFake());
    }

    @Test
    void injectItDirectlyToTestReturnsFake() {
        assertEquals("fake", barDirectInject.getRealOrFake());
    }

    @Test
    void injectItDirectlyToTestContextReturnsFake() {
        assertEquals("fake", context.createBean(Bar.class).getRealOrFake());
    }

    @MockBean(Bar.class)
    Bar fakeBar() {
        return new Bar(){
            @Override
            public String getRealOrFake() {
                return "fake";
            }
        };
    }
}
