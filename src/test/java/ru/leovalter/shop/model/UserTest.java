package ru.leovalter.shop.model;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static ru.leovalter.shop.UserTestData.ADMIN;
import static ru.leovalter.shop.UserTestData.USER;

class UserTest {


    @Test
    void shouldCreateNewUserWithoutArgs() {
        new User();
    }

    @Test
    void shouldInitializeUserByUser() {
        new User(USER);
        new User(ADMIN);
    }

    @Test
    void shouldCreateNewUserWithAllArgs() {
        new User(USER.getId(), USER.getName(), USER.getPassword(), USER.getEmail(), true, new Date(), USER.getRoles());
        new User(ADMIN.getId(), ADMIN.getName(), ADMIN.getPassword(), ADMIN.getEmail(), true, new Date(), ADMIN.getRoles());
    }

    @Test
    void testGetters() {
        User user = new User(USER);
        assertEquals(1000, user.getId());
        assertEquals("User", user.getName());
        assertEquals("userPassword", user.getPassword());
        assertEquals("user@gmail.com", user.getEmail());
        assertTrue(user.isEnabled());
        assertEquals(USER.getRegistered(), user.getRegistered());
        assertEquals(Set.of(Role.ROLE_USER), user.getRoles());

        User admin = new User(ADMIN);
        assertEquals(1001, admin.getId());
        assertEquals("Admin", admin.getName());
        assertEquals("adminPassword", admin.getPassword());
        assertEquals("admin@gmail.com", admin.getEmail());
        assertTrue(admin.isEnabled());
        assertEquals(ADMIN.getRegistered(), admin.getRegistered());
        assertEquals(Set.of(Role.ROLE_ADMIN), admin.getRoles());
    }

    @Test
    void testSetters() {
        User user = USER;
        user.setId(1111);
        assertEquals(1111, user.getId());
        user.setName("User Ivan");
        assertEquals("User Ivan", user.getName());
        user.setPassword("sdufhekw9983720");
        assertEquals("sdufhekw9983720", user.getPassword());
        user.setEmail("new_user@gmail.com");
        assertEquals("new_user@gmail.com", user.getEmail());
        user.setEnabled(false);
        assertFalse(user.isEnabled());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, 5, 5, 5, 55);
        user.setRegistered(calendar.getTime());
        assertEquals(calendar.getTime(), user.getRegistered());
        user.setRoles(Set.of(Role.ROLE_ADMIN));
        assertEquals(Set.of(Role.ROLE_ADMIN), user.getRoles());

        User admin = ADMIN;
        admin.setId(1212);
        assertEquals(1212, admin.getId());
        admin.setName("Admin Alex");
        assertEquals("Admin Alex", admin.getName());
        admin.setPassword("2891wyasujwu19928");
        assertEquals("2891wyasujwu19928", admin.getPassword());
        admin.setEmail("new_admin@gmail.com");
        assertEquals("new_admin@gmail.com", admin.getEmail());
        admin.setEnabled(false);
        assertFalse(admin.isEnabled());
        calendar.set(2020, 10, 10, 10, 10);
        admin.setRegistered(calendar.getTime());
        assertEquals(calendar.getTime(), admin.getRegistered());
        admin.setRoles(Set.of(Role.ROLE_USER));
        assertEquals(Set.of(Role.ROLE_USER), admin.getRoles());
    }


    @Test
    void testToString() {
        User user = USER;
        assertEquals("User{Id: 1000, name: , password: userPassword , email: user@gmail.com, enabled: true, registered: Sun Jun 20 10:00:00 MSK 3920, roles: [ROLE_USER]}", user.toString());
    }
}