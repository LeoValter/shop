package ru.leovalter.shop.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;
import java.util.Set;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends AbstractNamedEntity {

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "enabled")
    private boolean enabled = true;
    private Date registered = new Date();
    private Set<Role> roles;

    public User(User user) {
        this(user.getId(), user.getName(), user.getPassword(), user.getEmail(), user.isEnabled(), user.getRegistered(), user.getRoles());
    }

    public User(Integer id, String name, String password, String email, boolean enabled, Date registered, Set<Role> roles) {
        super(id, name);
        this.password = password;
        this.email = email;
        this.enabled = enabled;
        this.registered = registered;
        setRoles(roles);
    }

//    public void setRoles(Collection<Role> roles) {
//        this.roles = roles.isEmpty() ? EnumSet.noneOf(Role.class) : EnumSet.copyOf(roles);
//    }

    @Override
    public String toString() {
        return "User{Id: " + id +
                ", name: " +
                ", password: " + password + " , email: " + email +
                ", enabled: " + enabled +
                ", registered: " + registered +
                ", roles: " + roles +
                "" +
                "}";
    }
}
