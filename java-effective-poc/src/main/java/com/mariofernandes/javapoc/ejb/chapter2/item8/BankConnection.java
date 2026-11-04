package com.mariofernandes.javapoc.ejb.chapter2.item8;

public class BankConnection implements AutoCloseable {
    private final long nativeHandle; // Simulating a native handle
    private boolean closed = false;

    public BankConnection() {
        this.nativeHandle = System.currentTimeMillis(); // Simulating a unique handle
        System.out.println("BankConnection created");
    }

    public void executeOperation() {
        if (closed) {
            throw new IllegalStateException("BankConnection is closed");
        }
        System.out.println("Executing operation");
    }

    @Override
    public void close() {
        if (!closed) {
            closed = true;
            // Simulate releasing native resources
            System.out.println("Releasing native resources for handle: " + nativeHandle);
        }
    }
}
