package com.mariofernandes.javapoc.ejb.chapter2.item9;

import java.util.logging.Logger;

public class TempSession implements AutoCloseable {
    private final String identification;
    private boolean abort;
    private final Logger logger = Logger.getLogger(TempSession.class.getName());

    public TempSession(String identification) {
        this.identification = identification;
        this.abort = false;
        logger.info("? [Session " + identification + "] Opened and resources allocated.");
    }

    public void processOperation(String data) {
        if (abort) {
            throw new IllegalStateException("The operation failed: the session '" + identification + "' is already closed!");
        }
        logger.info("? [Session " + identification + "] Processing: " + data);
    }

    @Override
    public void close() {
        if (!abort) {
            abort = true;
            logger.info("\uD83D\uDD34 [Session " + identification + "] Closed with success. Resources released.");
        }
    }
}