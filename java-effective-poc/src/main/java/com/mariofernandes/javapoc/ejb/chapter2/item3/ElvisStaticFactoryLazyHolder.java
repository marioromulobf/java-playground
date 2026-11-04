package com.mariofernandes.javapoc.ejb.chapter2.item3;

// no inheritance, so the class is final
public final class ElvisStaticFactoryLazyHolder {
    private ElvisStaticFactoryLazyHolder() {
    }

    private static class Holder {
        private static final ElvisStaticFactoryLazyHolder INSTANCE = new ElvisStaticFactoryLazyHolder();
    }

    public static ElvisStaticFactoryLazyHolder getInstance() {
        // JVM guarantees that the class initialization phase is thread-safe,
        // so this approach is thread-safe without requiring explicit synchronization
        return Holder.INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building");
    }
}
