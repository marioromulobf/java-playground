package com.mariofernandes.javapoc.ejb.chapter2.item3;

public class ElvisStaticFactory {
    private static final ElvisStaticFactory INSTANCE = new ElvisStaticFactory();

    private ElvisStaticFactory() {
    }

    public static ElvisStaticFactory getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building");
    }
}
