package com.cuongnm.authorization.server.model;

import lombok.Data;
import org.hibernate.annotations.WhereJoinTable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User implements Serializable {
    public User() {
    }

    public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.tenantId = user.getTenantId();
        this.phone = user.getPhone();
        this.fullName = user.getFullName();
        this.postalCode = user.getPostalCode();
        this.enabled = user.isEnabled();
        this.accountNonExpired = user.isAccountNonExpired();
        this.credentialsNonExpired = user.isCredentialsNonExpired();
        this.accountNonLocked = user.isAccountNonLocked();
        this.roles = user.getRoles();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "tenantId")
    private String tenantId;

    @Column(name = "enabled")
    private boolean enabled;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "accountNonExpired")
    private boolean accountNonExpired;

    @Column(name = "credentialsNonExpired")
    private boolean credentialsNonExpired;

    @Column(name = "accountNonLocked")
    private boolean accountNonLocked;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id", referencedColumnName = "id")})
    private List<Role> roles;
}
