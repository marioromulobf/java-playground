package com.mariofernandes.javapoc.session.resources;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionResource {

    private static final String ATTRIBUTE_NAME = "user_name";

    @GetMapping("/set-attribute")
    public String setAttribute(@RequestParam(name = "name") String name, HttpSession session) {
        session.setAttribute(ATTRIBUTE_NAME, name);
        return "Session attribute 'user_name' set to: " + name + " [Session ID: " + session.getId() + "]";
    }

    @GetMapping("/get-attribute")
    public String getAttribute(HttpSession session) {
        String name = (String) session.getAttribute(ATTRIBUTE_NAME);
        if (name != null) {
            return "Stored name: " + name + " [Session ID: " + session.getId() + "]";
        }
        return "No name found in session. [Session ID: " + session.getId() + "]";
    }

    @GetMapping("/invalidate")
    public String invalidate(HttpSession session) {
        session.invalidate();
        return "Session Invalidated.";
    }
}
