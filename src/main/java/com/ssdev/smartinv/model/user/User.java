package com.ssdev.smartinv.model.user;

import com.ssdev.smartinv.model.common.BaseModel;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User extends BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50)
    private String name;

    @Column(unique = true, length = 150, nullable = false)
    private String email;

    @Column(length = 500)
    private String password;

    @Column(nullable = false)
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Role getRole() {
        return role;
    }
}
