package com.mariofernandes.javapoc.junit.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.DisabledIfEnvironmentVariables;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariables;

public class EnvironmentVariableConditionalTests {
    @Test
    @EnabledIfEnvironmentVariable(named = "ENV", matches = "staging-server")
    void testOnlyOnStagingServer() {}

    @Test
    @DisabledIfEnvironmentVariable(named = "ENV", matches = ".*development.*")
    void testNotOnDevelopmentWorkstation() {}

    @Test
    @EnabledIfEnvironmentVariables( value = {
            @EnabledIfEnvironmentVariable(named = "SNAP_ARCH", matches = "amd64"),
            @EnabledIfEnvironmentVariable(named = "PWD", matches = ".*java-junit-5-poc")
    })
    void testOnlyOnSpecificEnvironment() {}

    @Test
    @DisabledIfEnvironmentVariables( value = {
            @DisabledIfEnvironmentVariable(named = "ENV", matches = "production"),
            @DisabledIfEnvironmentVariable(named = "PWD", matches = ".*java-junit-5-poc")
    })
    void testNotOnSpecificEnvironment() {}
}
