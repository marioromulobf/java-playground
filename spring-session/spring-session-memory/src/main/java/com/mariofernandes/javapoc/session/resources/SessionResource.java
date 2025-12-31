package com.mariofernandes.javapoc.session.resources;

import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.mariofernandes.javapoc.session.util.Constants.ATTRIBUTE_ACCESS_COUNT;
import static com.mariofernandes.javapoc.session.util.Constants.ATTRIBUTE_NAME;

@RestController
public class SessionResource {

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

    @GetMapping("/count-access-session")
    public String countAccessSession(HttpSession session) {
        Integer accessCount = (Integer) session.getAttribute(ATTRIBUTE_ACCESS_COUNT);
        if (accessCount == null) {
            accessCount = 0;
        }
        accessCount++;
        session.setAttribute(ATTRIBUTE_ACCESS_COUNT, accessCount);
        return "Session Access Count: " + accessCount
                + "<br><br> <h3><b>Details Session</b></h3> "
                + "<br> - <b>ID</b>: " + session.getId()
                + "<br> - <b>Creation Time</b>: " + session.getCreationTime()
                + "<br> - <b>Last Accessed Time</b>: " + session.getLastAccessedTime()
                + "<br> - <b>Max Inactive Interval</b>: " + session.getMaxInactiveInterval() + " seconds"
                + "<br> - <b>Is New</b>: " + session.isNew();
    }
}
