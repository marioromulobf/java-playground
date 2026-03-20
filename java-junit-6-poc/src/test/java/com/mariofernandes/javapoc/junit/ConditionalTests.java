package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

public class ConditionalTests {

    @Test
    @EnabledOnOs(OS.MAC)
    void testOnlyOnMacOS() {

    }

    @TestOnMac
    void testOnMac() {

    }

    @Test
    @EnabledOnOs({OS.LINUX, OS.MAC})
    void testOnLinuxOrMac() {

    }

    @Test
    @DisabledOnOs(OS.WINDOWS)
    void testNotOnWindows() {

    }

    @Test
    @EnabledOnOs(architectures = "aarch64")
    void testOnAarch64() {

    }

    @Test
    @DisabledOnOs(architectures = "x86_64")
    void testOnX86_64() {

    }

    @Test
    @EnabledOnOs(value = OS.MAC, architectures = "aarch64")
    void testOnNewMacs() {

    }

    @Test
    @DisabledOnOs(value = OS.MAC, architectures = "x86_64")
    void testNotOnNewMacs() {

    }

    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testOnlyOnJava17() {

    }

    @Test
    @EnabledOnJre({JRE.JAVA_17, JRE.JAVA_21})
    void testOnJava17And21() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_21, max = JRE.JAVA_25)
    void testFromJava21To25() {

    }

    @Test
    @EnabledForJreRange(min = JRE.JAVA_21)
    void testOnJava21AndHigher() {

    }

    @Test
    @EnabledForJreRange(max = JRE.JAVA_18)
    void testFromJava17To18() {

    }

    @Test
    @DisabledOnJre(JRE.JAVA_19)
    void testNotOnJava19() {}

    @Test
    @DisabledForJreRange(min = JRE.JAVA_17, max = JRE.JAVA_21)
    void testNotFromJava17To21() {

    }

    @Test
    @DisabledForJreRange(min = JRE.JAVA_19)
    void testNotOnJava19AndHigher() {

    }

    @Test
    @DisabledForJreRange(max = JRE.JAVA_18)
    void testNotFromJava17To18() {

    }

    @Test
    @EnabledOnJre(versions = 20)
    void testOnlyOnJava20() {

    }

    @Test
    @DisabledOnJre(versions = {24, 26})
    void testNotOnJava24And26() {

    }

    @Test
    @EnabledForJreRange(maxVersion = 26)
    void testOnJava26AndHigher() {

    }

    @Test
    @DisabledForJreRange(minVersion = 25, maxVersion = 30)
    void testNotFromJava25To30() {}

}
