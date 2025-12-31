package com.mariofernandes.javapoc.session.resources;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SessionResource.class)
public class SessionResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSetAttribute_whenSetAttributeEndpointIsCalled_thenReturnExpectedMessage() throws Exception {
        mockMvc.perform(get("/set-attribute?name=Mario"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Session attribute 'user_name' set to: Mario [Session ID: ")));
    }

    @Test
    void testGetAttribute_whenGetAttributeEndpointIsCalled_thenReturnExpectedMessage() throws Exception {
        // First, set the attribute and capture the session
        MvcResult result = mockMvc.perform(get("/set-attribute?name=Mario"))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpSession sessionResult = (MockHttpSession) result.getRequest().getSession();
        Assertions.assertNotNull(sessionResult);

        // Then, get the attribute with the same session
        mockMvc.perform(get("/get-attribute").session(sessionResult))
                .andExpect(status().isOk())
                .andExpect(content().string("Stored name: Mario [Session ID: " + sessionResult.getId() + "]"));
    }

    @Test
    void testGetAttribute_whenGetAttributeEndpointIsCalledWithoutSettingAttribute_thenReturnNoNameFoundMessage() throws Exception {
        mockMvc.perform(get("/get-attribute"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("No name found in session. [Session ID: ")));
    }

    @Test
    void testInvalidate_whenInvalidateEndpointIsCalled_thenReturnSessionInvalidatedMessage() throws Exception {
        // First, set the attribute and capture the session
        MvcResult result = mockMvc.perform(get("/set-attribute?name=Mario"))
                .andExpect(status().isOk())
                .andReturn();

        MockHttpSession sessionResult = (MockHttpSession) result.getRequest().getSession();
        Assertions.assertNotNull(sessionResult);

        // Then, invalidate the session
        MvcResult invalidateResult = mockMvc.perform(get("/invalidate").session(sessionResult))
                .andExpect(status().isOk())
                .andExpect(content().string("Session Invalidated."))
                .andReturn();

        MockHttpSession invalidatedSession = (MockHttpSession) invalidateResult.getRequest().getSession(false);
        Assertions.assertNull(invalidatedSession);
    }

    @Test
    void testCountAccessSession_whenCountAccessSessionEndpointIsCalledMultipleTimes_thenReturnIncremented() throws Exception {
        MvcResult result = null;
        MockHttpSession session = null;
        String sessionId = null;

        for (int i = 1; i <= 3; i++) {
            if (i == 1) {
                result = mockMvc.perform(get("/count-access-session"))
                        .andExpect(status().isOk())
                        .andReturn();
                session = (MockHttpSession) result.getRequest().getSession();
                Assertions.assertNotNull(session);
                Assertions.assertTrue(session.isNew());
                sessionId = session.getId();
            } else {
                result = mockMvc.perform(get("/count-access-session").session(session))
                        .andExpect(status().isOk())
                        .andReturn();
                session = (MockHttpSession) result.getRequest().getSession();
                Assertions.assertNotNull(session);
                Assertions.assertFalse(session.isNew());
            }

            String expectedContentStart = "Session Access Count: " + i
                    + "<br><br> <h3><b>Details Session</b></h3> "
                    + "<br> - <b>ID</b>: " + sessionId;
            String responseContent = result.getResponse().getContentAsString();
            Assertions.assertTrue(responseContent.startsWith(expectedContentStart),
                    "Response content did not start with expected content on iteration " + i);
        }
    }
}
