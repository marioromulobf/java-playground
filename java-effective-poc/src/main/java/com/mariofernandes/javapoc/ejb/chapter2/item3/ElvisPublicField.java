package com.mariofernandes.javapoc.ejb.chapter2.item3;

public class ElvisPublicField {
    public static final ElvisPublicField INSTANCE = new ElvisPublicField();

    private ElvisPublicField() {
    }

    public void leaveTheBuilding() {
        System.out.println("Elvis has left the building");
    }
}

