package com.mariofernandes.javapoc.ejb.chapter2.item3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class ElvisSingletonTest {
    @Test
    void publicFieldReturnsSameInstance() {
        assertSame(ElvisPublicField.INSTANCE, ElvisPublicField.INSTANCE);
    }

    @Test
    void staticFactoryReturnsSameInstance() {
        assertSame(ElvisStaticFactory.getInstance(), ElvisStaticFactory.getInstance());
    }

    @Test
    void enumUsesSameInstance() {
        assertSame(ElvisEnum.INSTANCE, ElvisEnum.valueOf("INSTANCE"));
        assertSame(ElvisEnum.INSTANCE, ElvisEnum.values()[0]);
    }
}