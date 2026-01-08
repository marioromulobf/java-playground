package com.mariofernandes.javapoc.session.components;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.session.events.SessionCreatedEvent;
import org.springframework.session.events.SessionDeletedEvent;
import org.springframework.session.events.SessionDestroyedEvent;
import org.springframework.session.events.SessionExpiredEvent;
import org.springframework.stereotype.Component;

@Component
public class SessionEventListener {

    private static final Logger LOG = LoggerFactory.getLogger(SessionEventListener.class);

    @EventListener
    public void processSessionCreatedEvent(SessionCreatedEvent event) {
        LOG.info("Session created with ID: {} " +
                        "\n - Attributes: {} " +
                        "\n - Max Inactive Interval: {} seconds " +
                        "\n - Last Accessed Time: {} ",
                event.getSessionId(), event.getSession().getAttributeNames(), event.getSession().getMaxInactiveInterval(),
                event.getSession().getLastAccessedTime()
        );
    }

    @EventListener
    public void processSessionDeletedEvent(SessionDeletedEvent event) {
        LOG.info("Session deleted with ID: {}", event.getSessionId());
    }

    @EventListener
    public void processSessionDestroyedEvent(SessionDestroyedEvent event) {
        LOG.info("Session destroyed with ID: {}", event.getSessionId());
    }

    @EventListener
    public void processSessionExpiredEvent(SessionExpiredEvent event) {
        LOG.info("Session expired with ID: {}", event.getSessionId());
    }
}
