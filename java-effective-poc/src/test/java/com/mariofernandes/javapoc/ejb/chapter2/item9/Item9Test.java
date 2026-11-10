package com.mariofernandes.javapoc.ejb.chapter2.item9;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class Item9Test {
    @Test
    void tempSessionClosesAutomaticallyAndRejectsOperationsAfterClosing() {
        TempSession session = new TempSession("test-session");

        try (session) {
            assertDoesNotThrow(() -> session.processOperation("test operation"));
        }

        assertThrows(IllegalStateException.class,
                () -> session.processOperation("operation after close"));
    }

    @Test
    void tempSessionCloseIsIdempotent() {
        TempSession session = new TempSession("test-session");

        assertDoesNotThrow(() -> {
            session.close();
            session.close();
        });
        assertThrows(IllegalStateException.class,
                () -> session.processOperation("operation after close"));
    }

    @Test
    void auditSessionClosesAutomaticallyAndRejectsActionsAfterClosing() {
        AuditSession session = new AuditSession("test-user");

        try (session) {
            assertDoesNotThrow(() -> session.registerAction("test action"));
        }

        assertThrows(IllegalStateException.class,
                () -> session.registerAction("action after close"));
    }

    @Test
    void auditSessionCloseIsIdempotent() {
        AuditSession session = new AuditSession("test-user");

        assertDoesNotThrow(() -> {
            session.close();
            session.close();
        });
        assertThrows(IllegalStateException.class,
                () -> session.registerAction("action after close"));
    }

    @Test
    void sessionServiceExecutesSessionOperations() {
        assertDoesNotThrow(() -> new SessionService().executeSessionOperations());
    }

    @Test
    void sessionServiceHandlesAuditOperationException() {
        assertDoesNotThrow(() -> new SessionService().executeAuditSessionOperations());
    }
}