package com.mariofernandes.javapoc.ejb.chapter2.item3;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void lazyFactoryReturnsSameInstance() {
        assertSame(ElvisStaticFactoryLazy.getInstance(), ElvisStaticFactoryLazy.getInstance());
    }

    @Test
    void lazyHolderReturnsSameInstance() {
        assertSame(ElvisStaticFactoryLazyHolder.getInstance(), ElvisStaticFactoryLazyHolder.getInstance());
    }

    @Test
    void lazyHolderAtomicReturnsSameInstance() {
        assertSame(ElvisStaticFactoryLazyHolderAtomic.getInstance(),
                ElvisStaticFactoryLazyHolderAtomic.getInstance());
    }

    @Test
    void lazySyncReturnsSameInstance() {
        assertSame(ElvisStaticFactoryLazySync.getInstance(), ElvisStaticFactoryLazySync.getInstance());
    }

    @Test
    void lazyDoubleCheckReturnsSameInstance() {
        assertSame(ElvisStaticFactoryLazyDoubleCheck.getInstance(),
                ElvisStaticFactoryLazyDoubleCheck.getInstance());
    }

    @Test
    void atomicHolderRejectsReflectiveInstantiation() throws Exception {
        ElvisStaticFactoryLazyHolderAtomic.getInstance();
        assertReflectionIsRejected(ElvisStaticFactoryLazyHolderAtomic.class);
    }

    @Test
    void synchronizedSingletonRejectsReflectiveInstantiation() throws Exception {
        ElvisStaticFactoryLazySync.getInstance();
        assertReflectionIsRejected(ElvisStaticFactoryLazySync.class);
    }

    @Test
    void doubleCheckSingletonRejectsReflectiveInstantiation() throws Exception {
        ElvisStaticFactoryLazyDoubleCheck.getInstance();
        assertReflectionIsRejected(ElvisStaticFactoryLazyDoubleCheck.class);
    }

    private static void assertReflectionIsRejected(Class<?> singletonClass) throws Exception {
        var constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);

        var exception = assertThrows(
                InvocationTargetException.class,
                constructor::newInstance
        );

        assertInstanceOf(IllegalStateException.class, exception.getCause());
    }

    @Test
    void reflectionCreatesAnotherPublicFieldInstance() throws ReflectiveOperationException {
        assertNotSame(ElvisPublicField.INSTANCE, createWithReflection(ElvisPublicField.class));
    }

    @Test
    void reflectionCreatesAnotherStaticFactoryInstance() throws ReflectiveOperationException {
        assertNotSame(ElvisStaticFactory.getInstance(),
                createWithReflection(ElvisStaticFactory.class));
    }

    @Test
    void reflectionCreatesAnotherLazyFactoryInstance() throws ReflectiveOperationException {
        assertNotSame(ElvisStaticFactoryLazy.getInstance(),
                createWithReflection(ElvisStaticFactoryLazy.class));
    }

    @Test
    void reflectionCreatesAnotherLazyHolderInstance() throws ReflectiveOperationException {
        assertNotSame(ElvisStaticFactoryLazyHolder.getInstance(),
                createWithReflection(ElvisStaticFactoryLazyHolder.class));
    }

    private static <T> T createWithReflection(Class<T> singletonClass)
            throws ReflectiveOperationException {
        Constructor<T> constructor = singletonClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }

    @Test
    void reflectionCreatesAnotherInstanceAfterResettingInitializedFlag()
            throws ReflectiveOperationException {
        ElvisStaticFactoryLazyHolderAtomic singleton =
                ElvisStaticFactoryLazyHolderAtomic.getInstance();

        Field initializedField =
                ElvisStaticFactoryLazyHolderAtomic.class.getDeclaredField("INITIALIZED");
        initializedField.setAccessible(true);
        AtomicBoolean initialized = (AtomicBoolean) initializedField.get(null);
        initialized.set(false);

        Constructor<ElvisStaticFactoryLazyHolderAtomic> constructor =
                ElvisStaticFactoryLazyHolderAtomic.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        assertNotSame(singleton, constructor.newInstance());
    }
}