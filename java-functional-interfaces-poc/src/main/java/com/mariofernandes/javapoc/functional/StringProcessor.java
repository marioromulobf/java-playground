package com.mariofernandes.javapoc.functional;

/**
 * Custom Functional Interface for string processing
 * Demonstrates how to create your own functional interface
 */
@FunctionalInterface
public interface StringProcessor {
    
    /**
     * Single abstract method - processes a string
     */
    String process(String input);
    
    /**
     * Default method for chaining operations
     */
    default StringProcessor andThen(StringProcessor after) {
        return input -> after.process(this.process(input));
    }
    
    /**
     * Default method for composing operations (reverse order)
     */
    default StringProcessor compose(StringProcessor before) {
        return input -> this.process(before.process(input));
    }
    
    /**
     * Static factory method
     */
    static StringProcessor identity() {
        return input -> input;
    }
    
    /**
     * Static utility method
     */
    static StringProcessor toUpperCase() {
        return String::toUpperCase;
    }
    
    /**
     * Static utility method
     */
    static StringProcessor toLowerCase() {
        return String::toLowerCase;
    }
    
    /**
     * Static utility method
     */
    static StringProcessor trim() {
        return String::trim;
    }
}
