package com.mariofernandes.javapoc.ejb.chapter2.item9;

import java.util.logging.Logger;

public class AuditSession implements AutoCloseable {
    private final String userId;
    private boolean open;
    private final Logger logger = Logger.getLogger(AuditSession.class.getName());

    public AuditSession(String userId) {
        this.userId = userId;
        this.open = true;
        logger.info("[LOG] Audit Session opened for userId: " + userId);
    }

    public void registerAction(String action) {
        if (!open) {
            throw new IllegalStateException("Audit Session for userId: " + userId + " is already closed!");
        }
        logger.info("[LOG] Action registered for userId: " + userId + " - " + action);
    }

    @Override
    public void close() {
        if (open) {
            open = false;
            logger.info("[LOG] Audit Session closed for userId: " + userId);
        }
    }
}
