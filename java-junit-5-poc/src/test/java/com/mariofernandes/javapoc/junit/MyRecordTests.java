package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

record MyRecordTests() {

    @Test
    void addition() {
        Assertions.assertEquals(2, new Calcularor().add(1, 1));
    }

}
