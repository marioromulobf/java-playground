package com.mariofernandes.javapoc.ejb.chapter2.item3;

// no inheritance, so the class is final
public final class ElvisStaticFactoryLazySync {
    private static ElvisStaticFactoryLazySync instance;

    private ElvisStaticFactoryLazySync() {
        // Prevent instantiation via reflection,
        // not guaranteed to work in all cases, but it is a good practice to include it
        if (instance != null) {
            throw new IllegalStateException("Singleton already initialized.");
        }
    }

    // the monitor lock is acquired on the class object, so only one thread can execute this method at a time
    public static synchronized ElvisStaticFactoryLazySync getInstance() {
        // Synchronized, thread-safe
        if (instance == null) {
            instance = new ElvisStaticFactoryLazySync();
        }

        return instance;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building");
    }
}
