package com.mariofernandes.javapoc.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Tests with standard display name")
public class DisplayNameTest {

    @Test
    @DisplayName("Custom test name containing spaces")
    void testWithDisplayNameContainingSpaces() {

    }

    @Test
    @DisplayName("╯°□°）╯")
    void testWithDisplayNameContainingSpecialCharacters() {

    }

    @Test
    @DisplayName("😜\uD83D\uDE31")
    void testWithDisplayNameContainingEmoji() {

    }
}
