package com.mariofernandes.javapoc.ejb.chapter3.item10;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class UserHighQualityTest {
    @Test
    void constructorShouldInitializeImmutableFields() {
        UserHighQuality user = new UserHighQuality("mario@email.com", 30, 5000.0f);

        assertEquals("mario@email.com", user.getEmail());
        assertEquals(30, user.getAge());
        assertEquals(5000.0f, user.getSalary());
    }

    @Test
    void nameShouldBeNullableAndChangeable() {
        UserHighQuality user = new UserHighQuality("mario@email.com", 30, 5000.0f);

        assertNull(user.getName());

        user.setName("Mario");
        assertEquals("Mario", user.getName());

        user.setName(null);
        assertNull(user.getName());
    }

    @Test
    void equalUsersShouldBeEqual() {
        UserHighQuality first = new UserHighQuality("mario@email.com", 30, 5000.0f);
        UserHighQuality second = new UserHighQuality("mario@email.com", 30, 5000.0f);

        first.setName("Mario");
        second.setName("Outro nome");

        assertEquals(first, second);
    }

    @Test
    void objectShouldBeEqualToItself() {
        UserHighQuality user = new UserHighQuality("mario@email.com", 30, 5000.0f);

        assertEquals(user, user);
    }

    @Test
    void usersWithDifferentFieldsShouldNotBeEqual() {
        UserHighQuality user = new UserHighQuality("mario@email.com", 30, 5000.0f);

        assertNotEquals(user,
                new UserHighQuality("outro@email.com", 30, 5000.0f));
        assertNotEquals(user,
                new UserHighQuality("mario@email.com", 31, 5000.0f));
        assertNotEquals(user,
                new UserHighQuality("mario@email.com", 30, 6000.0f));
    }

    @Test
    void userShouldNotBeEqualToAnotherType() {
        UserHighQuality user = new UserHighQuality("mario@email.com", 30, 5000.0f);

        assertNotEquals(user, "mario@email.com");
        assertNotEquals(user, null);
    }

    @Test
    void equalUsersShouldHaveTheSameHashCode() {
        UserHighQuality first = new UserHighQuality("mario@email.com", 30, 5000.0f);
        UserHighQuality second = new UserHighQuality("mario@email.com", 30, 5000.0f);

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }
}