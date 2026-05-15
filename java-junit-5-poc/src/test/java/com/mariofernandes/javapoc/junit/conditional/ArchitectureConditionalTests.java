package com.mariofernandes.javapoc.junit.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class ArchitectureConditionalTests {
    @Test
    @EnabledOnOs(architectures = "aarch64")
    void testOnAarch64() {}

    @Test
    @DisabledOnOs(architectures = "x86_64")
    void testNotOnX86_64() {}

    @Test
    @EnabledOnOs(value = OS.MAC, architectures = "aarch64")
    void testOnNewMacs() {}

    @Test
    @DisabledOnOs(value = OS.MAC, architectures = "aarch64")
    void testNotOnNewMacs() {}
}
