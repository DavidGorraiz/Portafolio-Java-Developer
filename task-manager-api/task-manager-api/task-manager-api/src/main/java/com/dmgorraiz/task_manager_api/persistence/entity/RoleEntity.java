package com.dmgorraiz.task_manager_api.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "role")
public class RoleEntity {
    @Id
    private String role;

    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }
}
