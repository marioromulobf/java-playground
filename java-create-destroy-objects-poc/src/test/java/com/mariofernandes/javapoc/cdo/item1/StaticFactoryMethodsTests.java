package com.mariofernandes.javapoc.cdo.item1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.Random;

/**
 * Test class for static factory methods.
 * This is a simple way to create instances of classes without using constructors directly.
 */
public class StaticFactoryMethodsTests {
    @Test
    void testStaticFactoryMethodsBigInteger() {
        // Static factory methods can have names that describe the instances they return,
        // making the code more readable and expressive.
        // limit the range to Integer.MAX_VALUE to avoid overflow when converting to int
        var bigInteger = BigInteger.probablePrime(13, new Random());

        Assertions.assertNotNull(bigInteger);
        Assertions.assertTrue(bigInteger.isProbablePrime(bigInteger.intValueExact()));
        Assertions.assertTrue(Util.isPrime(bigInteger.intValueExact()));
    }
}
