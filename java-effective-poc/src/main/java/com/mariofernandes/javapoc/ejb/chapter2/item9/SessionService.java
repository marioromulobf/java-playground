package com.mariofernandes.javapoc.ejb.chapter2.item9;

import java.util.logging.Logger;

public class SessionService {
    private final Logger logger = Logger.getLogger(SessionService.class.getName());
    public void executeSessionOperations() {
        try (TempSession session = new TempSession("financial-session-001")) {
            session.processOperation("Operation 1");
            session.processOperation("Operation 2");
            // Additional operations can be added here
        }
        logger.info("Session operations completed.");
    }

    public void executeAuditSessionOperations() {
        try (AuditSession auditSession = new AuditSession("user123")) {
            auditSession.registerAction("Login");
            auditSession.registerAction("View Account Details");
            if (true) {
                throw new RuntimeException("Simulated exception during audit session operations.");
            }
            auditSession.registerAction("Action never reached due to exception");
        } catch (RuntimeException e) {
            logger.info("Exception treated during audit session operations: " + e.getMessage());
        }
        logger.info("Audit session operations completed.");
    }
}
