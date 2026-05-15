package com.mariofernandes.javapoc.junit.conditional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledInNativeImage;
import org.junit.jupiter.api.condition.EnabledInNativeImage;

public class NativeImageConditionalTests {
    @Test
    @EnabledInNativeImage
    void testOnlyWithinNativeImage() {}

    @Test
    @DisabledInNativeImage
    void testNeverWithinNativeImage() {}
}
