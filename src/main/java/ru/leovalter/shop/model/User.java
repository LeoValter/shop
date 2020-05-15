package ru.leovalter.shop.model;

import java.util.Date;
import java.util.Set;

public class User extends AbstractBaseEntity {
    private String email;
    private String password;
    private boolean enabled = true;
    private Date registered = new Date();
    private Set<Role> roles;
}
