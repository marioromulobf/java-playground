package com.mariofernandes.javapoc.ejb.chapter2.item3;

// no inheritance, so the class is final
public final class ElvisStaticFactoryLazyDoubleCheck {
    // volatile is used to ensure that multiple threads handle the instance variable correctly
    // when it is being initialized to the ElvisStaticFactoryLazyDoubleCheck instance
    private static volatile ElvisStaticFactoryLazyDoubleCheck instance;

    private ElvisStaticFactoryLazyDoubleCheck() {
        // Prevent instantiation via reflection,
        // not guaranteed to work in all cases, but it is a good practice to include it
        if (instance != null) {
            throw new IllegalStateException("Singleton already initialized.");
        }
    }

    public static ElvisStaticFactoryLazyDoubleCheck getInstance() {
        // Synchronized, thread-safe
        if (instance == null) {
            // Double-check locking pattern,
            // avoids the overhead of acquiring a lock every time the method is called
            synchronized (ElvisStaticFactoryLazyDoubleCheck.class) {
                if (instance == null) {
                    instance = new ElvisStaticFactoryLazyDoubleCheck();
                }
            }
        }

        return instance;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building");
    }
}
