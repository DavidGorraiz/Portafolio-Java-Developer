package com.dmgorraiz.task_manager_api.persistence.audit;

import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditBoardListener {

    private BoardEntity currentValue;

    @PostLoad
    public void postLoad(BoardEntity board) {
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(board);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(BoardEntity entity) {
        System.out.println("POST PERSIST OR UPDATE");
        System.out.println("OLD VALUE: " + this.currentValue);
        System.out.println("NEW VALUE: " + entity.toString());
    }

    @PreRemove
    public void onPreDelete(BoardEntity entity) {
        System.out.println(entity.toString());
    }
}
