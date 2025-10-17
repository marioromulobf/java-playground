package com.mariofernandes.javapoc.functional;

/**
 * Custom Functional Interface for mathematical operations
 */
@FunctionalInterface
public interface Calculator {
    
    /**
     * Single abstract method - performs calculation on two integers
     */
    int calculate(int a, int b);
    
    /**
     * Default method for adding additional operation
     */
    default Calculator andThen(Calculator after) {
        return (a, b) -> after.calculate(this.calculate(a, b), 0);
    }
    
    /**
     * Static factory methods for common operations
     */
    static Calculator add() {
        return (a, b) -> a + b;
    }
    
    static Calculator subtract() {
        return (a, b) -> a - b;
    }
    
    static Calculator multiply() {
        return (a, b) -> a * b;
    }
    
    static Calculator divide() {
        return (a, b) -> {
            if (b == 0) throw new ArithmeticException("Division by zero");
            return a / b;
        };
    }
    
    static Calculator power() {
        return (a, b) -> (int) Math.pow(a, b);
    }
    
    static Calculator max() {
        return Math::max;
    }
    
    static Calculator min() {
        return Math::min;
    }
}
