package com.mariofernandes.javapoc.junit.nested;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Stack;

/*
*  Expected result:
*
*  A stack ✔
*  ├─ is instantiated with new Stack() ✔
*  └─ when new ✔
*     ├─ is empty ✔
*     ├─ throws EmptyStackException when popped ✔
*     ├─ throws EmptyStackException when peeked ✔
*     └─ after pushing an element ✔
*        ├─ it is no longer empty ✔
*        ├─ returns the element when popped and is empty ✔
*        └─ returns the element when peeked but remains not empty ✔
* */
@DisplayName("A stack")
public class StackTests {

    private Stack<Object> stack;

    @Test
    @DisplayName("is instantiated with new Stack()")
    void testIsInstantiatedWithNew() {
        new Stack<>();
    }

    @Nested
    @DisplayName("when new")
    class WhenNew {
        @BeforeEach
        void createNewStack() {
            stack = new Stack<>();
        }

        @Test
        @DisplayName("is empty")
        void testIsEmpty() {
            Assertions.assertTrue(stack.isEmpty());
        }

        @Test
        @DisplayName("throws EmptyStackException when popped")
        void testThrowsExceptionWhenPooped() {
            Assertions.assertThrows(EmptyStackException.class, stack::pop);
        }

        @Test
        @DisplayName("throws EmptyStackException when peeked")
        void testThrowsExceptionWhenPeeked() {
            Assertions.assertThrows(EmptyStackException.class, stack::peek);
        }

        @Nested
        @DisplayName("after pushing an element")
        class AfterPushing {
            private String anElement = "an element";

            @BeforeEach
            void pushAnElement() {
                stack.push(anElement);
            }

            @Test
            @DisplayName("it is no longer empty")
            void testIsNotEmpty() {
                Assertions.assertFalse(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when popped and is empty")
            void testReturnElementWhenPopped() {
                Assertions.assertEquals(anElement, stack.pop());
                Assertions.assertTrue(stack.isEmpty());
            }

            @Test
            @DisplayName("returns the element when peeked but remains not empty")
            void testReturnElementWhenPeeked() {
                Assertions.assertEquals(anElement, stack.peek());
                Assertions.assertFalse(stack.isEmpty());
            }
        }
    }
}
