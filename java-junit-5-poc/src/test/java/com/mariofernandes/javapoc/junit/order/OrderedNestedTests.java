package com.mariofernandes.javapoc.junit.order;

import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

@TestClassOrder(ClassOrderer.OrderAnnotation.class)
public class OrderedNestedTests {
    @Nested
    @Order(1)
    class PrimaryTests {
        @Test
        void testOne() {}
    }

    @Nested
    @Order(2)
    class SecondaryTestes {
        @Test
        void testTwo() {}
    }
}
