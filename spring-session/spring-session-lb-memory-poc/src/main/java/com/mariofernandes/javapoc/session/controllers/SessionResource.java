package com.mariofernandes.javapoc.session.controllers;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.mariofernandes.javapoc.session.util.Constants.ATTRIBUTE_ACCESS_COUNT;
import static com.mariofernandes.javapoc.session.util.Constants.RESPONSE_SESSION_DETAILS_TEMPLATE;

@RestController
public class SessionResource {

    @GetMapping("/count-access-session")
    public ResponseEntity<String> countAccessSession(HttpSession session) {
        Integer accessCount = (Integer) session.getAttribute(ATTRIBUTE_ACCESS_COUNT);
        if (accessCount == null) {
            accessCount = 0;
        }
        accessCount++;
        session.setAttribute(ATTRIBUTE_ACCESS_COUNT, accessCount);

        return ResponseEntity.ok(
                String.format(RESPONSE_SESSION_DETAILS_TEMPLATE,
                        accessCount,
                        session.getId(),
                        session.getCreationTime(),
                        session.getLastAccessedTime(),
                        session.getMaxInactiveInterval(),
                        session.isNew())
        );
    }
}
