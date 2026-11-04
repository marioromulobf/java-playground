package com.mariofernandes.javapoc.ejb.chapter2.item8;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BankConnectionTest {
    @Test
    void tryWithResourcesClosesConnectionAfterBlock() {
        BankConnection connection = new BankConnection();

        try (connection) {
            assertDoesNotThrow(connection::executeOperation);
        }

        assertThrows(IllegalStateException.class, connection::executeOperation);
    }

    @Test
    void closeIsIdempotent() {
        BankConnection connection = new BankConnection();

        assertDoesNotThrow(() -> {
            connection.close();
            connection.close();
        });

        assertThrows(IllegalStateException.class, connection::executeOperation);
    }
}