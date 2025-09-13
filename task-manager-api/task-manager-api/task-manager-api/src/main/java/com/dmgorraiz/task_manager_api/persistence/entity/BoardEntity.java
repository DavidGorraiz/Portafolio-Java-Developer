package com.dmgorraiz.task_manager_api.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "boards")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
    @Column(name = "owner_id",nullable = false)
    private Long ownerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_idd", referencedColumnName = "id", insertable = false, updatable = false)
    @JsonIgnore
    private UserEntity owner;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BoardMemberEntity> members;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<ListEntity> lists;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<TaskEntity> tasks;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public UserEntity getOwner() {
        return owner;
    }

    public void setOwner(UserEntity user) {
        this.owner = user;
    }

    public List<BoardMemberEntity> getMembers() {
        return members;
    }

    public void setMembers(List<BoardMemberEntity> members) {
        this.members = members;
    }

    public List<ListEntity> getLists() {
        return lists;
    }

    public void setLists(List<ListEntity> lists) {
        this.lists = lists;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
