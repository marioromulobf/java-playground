package com.mariofernandes.javapoc.junit.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.junit.jupiter.api.condition.DisabledIfSystemProperty;
import org.junit.jupiter.api.condition.EnabledIfSystemProperties;
import org.junit.jupiter.api.condition.EnabledIfSystemProperty;

public class SystemPropertyConditionalTests {
    @Test
    @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*")
    // os.arch is equal amd64
    void testOnyOn64BitArchitectures() {}

    @Test
    @DisabledIfSystemProperty(named = "ci-serve", matches = "true")
    // ci-server is null
    void testNotOnCiServer() {}

    @Test
    @EnabledIfSystemProperties(value = {
        @EnabledIfSystemProperty(named = "os.arch", matches = ".*64.*"),
        @EnabledIfSystemProperty(named = "ci-server", matches = "true")
    })
    void testOn64BitArchitecturesAndCiServer() {}

    @Test
    @DisabledIfSystemProperties(value = {
        @DisabledIfSystemProperty(named = "os.arch", matches = ".*64.*"),
        @DisabledIfSystemProperty(named = "ci-server", matches = "true")
    })
    void testNotOn64BitArchitecturesAndCiServer() {}
}
