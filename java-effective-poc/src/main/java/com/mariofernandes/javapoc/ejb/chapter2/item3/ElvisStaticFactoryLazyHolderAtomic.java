package com.mariofernandes.javapoc.ejb.chapter2.item3;

import java.util.concurrent.atomic.AtomicBoolean;

// no inheritance, so the class is final
public final class ElvisStaticFactoryLazyHolderAtomic {

    // default value is false, so it is not necessary to initialize it explicitly
    private static final AtomicBoolean INITIALIZED = new AtomicBoolean();

    private ElvisStaticFactoryLazyHolderAtomic() {
        // Prevent instantiation via reflection,
        // not guaranteed to work in all cases, but it is a good practice to include it
        if (!INITIALIZED.compareAndSet(false, true)) {
            throw new IllegalStateException("Singleton already initialized.");
        }
    }

    private static class Holder {
        private static final ElvisStaticFactoryLazyHolderAtomic INSTANCE = new ElvisStaticFactoryLazyHolderAtomic();
    }

    public static ElvisStaticFactoryLazyHolderAtomic getInstance() {
        // JVM guarantees that the class initialization phase is thread-safe,
        // so this approach is thread-safe without requiring explicit synchronization
        return Holder.INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building");
    }
}
