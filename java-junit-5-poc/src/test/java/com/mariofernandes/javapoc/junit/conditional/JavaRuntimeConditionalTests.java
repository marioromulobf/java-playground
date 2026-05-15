package com.mariofernandes.javapoc.junit.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledForJreRange;
import org.junit.jupiter.api.condition.DisabledOnJre;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.JRE;

public class JavaRuntimeConditionalTests {
    @Test
    @EnabledOnJre(JRE.JAVA_17)
    void testOnlyOnJava17() {}

    @Test
    @EnabledOnJre({JRE.JAVA_17, JRE.JAVA_21})
    void testOnJava17And21() {}

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    void testFromJava9To11() {}

    @Test
    @EnabledForJreRange(min = JRE.JAVA_9)
    void testOnJava9AndHigher() {}

    @Test
    @EnabledForJreRange(max = JRE.JAVA_11)
    void testFromJava8To11() {}

    @Test
    @DisabledOnJre(JRE.JAVA_9)
    void testNotOnJava9() {}

    @Test
    @DisabledForJreRange(min = JRE.JAVA_9, max = JRE.JAVA_11)
    void testNotFromJava9To11() {}

    @Test
    @DisabledForJreRange(min = JRE.JAVA_9)
    void testNotOnJava9AndHigher() {}

    @Test
    @DisabledForJreRange(max = JRE.JAVA_11)
    void testNotFromJava8To11() {}

    @Test
    @EnabledOnJre(versions = 26)
    void testOnlyOnJava26() {}

    @Test
    @EnabledOnJre(versions = {25, 26})
    // Can also be expressed as follows.
    // @EnabledOnJre(value = JRE.JAVA_25, versions = 26)
    void testOnlyOnJava25And26() {}

    @Test
    @EnabledForJreRange(minVersion = 26)
    void testOnJava26AndHigher() {}

    @Test
    @EnabledForJreRange(minVersion = 25, maxVersion = 27)
    // Can also be expressed as follows.
    // @EnabledForJreRange(min = JRE.JAVA_25, maxVersion = 27)
    void testFromJava25To27() {}

    @Test
    @DisabledOnJre(versions = 26)
    void testNotOnJava26() {}

    @Test
    @DisabledOnJre(versions = {25, 26})
    // Can also be expressed as follows.
    // @DisabledOnJre(value = JRE.JAVA_25, versions = 26)
    void testNotOnJava25And26() {}

    @Test
    @DisabledForJreRange(minVersion = 26)
    void testNotOnJava26AndHigher() {}

    @Test
    @DisabledForJreRange(minVersion = 25, maxVersion = 27)
    // Can also be expressed as follows.
    // @DisabledForJreRange(min = JRE.JAVA_25, maxVersion = 27)
    void testNotFromJava25To27() {}
}
