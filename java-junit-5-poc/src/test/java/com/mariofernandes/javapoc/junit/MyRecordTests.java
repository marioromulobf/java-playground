package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

record MyRecordTests() {

    @Test
    void addition() {
        Assertions.assertEquals(2, new Calculator().add(1, 1));
    }

}
