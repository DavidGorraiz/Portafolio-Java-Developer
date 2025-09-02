package com.dmgorraiz.task_manager_api.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    private String username;

    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private Boolean locked;
    @Column(nullable = false)
    private Boolean disabled;

    @OneToMany(mappedBy = "owner")
    private List<BoardEntity> boards;

    @OneToMany(mappedBy = "user")
    private List<BoardMemberEntity> boardMembers;

    @OneToMany(mappedBy = "user")
    private List<UserRoleEntity> userRoles;

    @OneToMany(mappedBy = "user")
    private List<AttachmentEntity> attachments;

    @OneToMany(mappedBy = "author")
    private List<CommentEntity> comments;

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

    public List<BoardEntity> getBoards() {
        return boards;
    }

    public void setBoards(List<BoardEntity> boards) {
        this.boards = boards;
    }

    public List<BoardMemberEntity> getBoardMembers() {
        return boardMembers;
    }

    public void setBoardMembers(List<BoardMemberEntity> boardMembers) {
        this.boardMembers = boardMembers;
    }

    public List<UserRoleEntity> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleEntity> userRoles) {
        this.userRoles = userRoles;
    }

    public List<AttachmentEntity> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<AttachmentEntity> attachments) {
        this.attachments = attachments;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}
