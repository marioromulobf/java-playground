package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InterfaceTests implements TestLifecycleLogger, TimeExecutionLogger, TestInterfaceDynamicTests {

    @Override
    public boolean isPalindrome(String text) {
        return true;
    }

    @Test
    void testIsEqualValue() {
        Assertions.assertEquals(1, "a".length(), "is always equal");
    }
}
