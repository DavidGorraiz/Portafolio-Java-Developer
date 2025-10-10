package com.dmgorraiz.task_manager_api.persistence.audit;

import com.dmgorraiz.task_manager_api.persistence.entity.BoardEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.ListEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditListListener {

    private ListEntity currentValue;

    @PostLoad
    public void postLoad(ListEntity list) {
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(list);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(ListEntity entity) {
        System.out.println("POST PERSIST OR UPDATE");
        System.out.println("OLD VALUE: " + this.currentValue);
        System.out.println("NEW VALUE: " + entity.toString());
    }

    @PreRemove
    public void onPreDelete(ListEntity entity) {
        System.out.println(entity.toString());
    }
}
