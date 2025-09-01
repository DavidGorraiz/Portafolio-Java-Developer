package com.dmgorraiz.task_manager_api.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "task_manager_users")
public class UserEntity {
    @Id
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean locked;
    @Column(nullable = false)
    private Boolean disabled;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getLocked() {
        return locked;
    }

    public void setLocked(Boolean locked) {
        this.locked = locked;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }
}
