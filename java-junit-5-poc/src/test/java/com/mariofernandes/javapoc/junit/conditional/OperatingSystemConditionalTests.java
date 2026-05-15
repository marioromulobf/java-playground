package com.mariofernandes.javapoc.junit.conditional;

import com.mariofernandes.javapoc.junit.annotation.TestOnMac;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

public class OperatingSystemConditionalTests {
    @Test
    @EnabledOnOs(OS.MAC)
    void testOnlyOnMacOs() {}

    @TestOnMac
    void testOnMac() {}

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testOnLinuxOrMac() {}

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNotOnWindows() {}
}
