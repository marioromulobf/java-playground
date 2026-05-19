package com.mariofernandes.javapoc.junit.order;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {
    @Test
    @Order(1)
    void testNullValues() {}

    @Test
    @Order(3)
    void testEmptyValues() {}

    @Test
    @Order(2)
    void testValidValues() {}
}
