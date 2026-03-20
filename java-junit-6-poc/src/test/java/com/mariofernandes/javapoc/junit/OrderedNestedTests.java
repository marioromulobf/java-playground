package com.mariofernandes.javapoc.junit;

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
        void test1() {

        }
    }

    @Nested
    @Order(2)
    class SecondaryTests {
        @Test
        void test2() {

        }
    }
}
