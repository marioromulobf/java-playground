package com.mariofernandes.javapoc.junit.interfaces;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *  Expected output:
 *  c.m.j.u.i.LifecycleTests beforeAllTests - INFO: Before all tests
 *  c.m.j.u.i.LifecycleTests beforeEachTest - INFO: About to execute [dynamicTestsForPalindromes()]
 *  c.m.j.u.i.TimingExtension afterTestExecution - INFO: Method [dynamicTestsForPalindromes] took 32 ms.
 *  c.m.j.u.i.LifecycleTests afterEachTest - INFO: Finished executing [dynamicTestsForPalindromes()]
 *  c.m.j.u.i.LifecycleTests beforeEachTest - INFO: About to execute [testIsEqualValue()]
 *  c.m.j.u.i.TimingExtension afterTestExecution - INFO: Method [testIsEqualValue] took 3 ms.
 *  c.m.j.u.i.LifecycleTests afterEachTest - INFO: Finished executing [testIsEqualValue()]
 *  c.m.j.u.i.LifecycleTests afterAllTests - INFO: After all tests
 */
public class InterfaceTests implements LifecycleTests, TimeExecutionLogger, DynamicTests {
    @Test
    void testIsEqualValue() {
        Assertions.assertEquals(1, "a".length(), "is always equal");
    }
}
