package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

@Disabled("Disabled until bug #666 has been fixed")
public class DisabledClassTests {

    @Test
    void testWillBeSkipped() {

    }
}
