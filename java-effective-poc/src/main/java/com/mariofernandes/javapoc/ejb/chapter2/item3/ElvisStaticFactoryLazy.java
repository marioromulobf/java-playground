package com.mariofernandes.javapoc.ejb.chapter2.item3;

public class ElvisStaticFactoryLazy {
    private static ElvisStaticFactoryLazy instance;

    private ElvisStaticFactoryLazy() {
    }

    public static ElvisStaticFactoryLazy getInstance() {
        // No synchronization, not thread-safe
        if (instance == null) {
            instance = new ElvisStaticFactoryLazy();
        }

        return instance;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building");
    }
}
