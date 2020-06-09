package ru.leovalter.shop;

import ru.leovalter.shop.model.Role;
import ru.leovalter.shop.model.User;

import java.util.Date;
import java.util.Set;

import static ru.leovalter.shop.model.AbstractBaseEntity.START_SEQUENCE;

public class UserTestData {

    public static final int USER_ID = START_SEQUENCE;
    public static final int ADMIN_ID = START_SEQUENCE + 1;

    public static final User USER = new User(USER_ID, "User", "userPassword", "user@gmail.com", true, new Date(2020, 5, 20, 10, 00), Set.of(Role.ROLE_USER));
    public static final User ADMIN = new User(ADMIN_ID, "Admin", "adminPassword", "admin@gmail.com", true, new Date(2020, 5, 10, 10, 00), Set.of(Role.ROLE_ADMIN));

}
