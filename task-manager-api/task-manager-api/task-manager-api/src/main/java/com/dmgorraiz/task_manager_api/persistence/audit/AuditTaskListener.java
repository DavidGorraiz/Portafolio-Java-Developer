package com.dmgorraiz.task_manager_api.persistence.audit;

import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditTaskListener {

    private TaskEntity currentValue;

    @PostLoad
    public void postLoad(TaskEntity task) {
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(task);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(TaskEntity entity) {
        System.out.println("POST PERSIST OR UPDATE");
        System.out.println("OLD VALUE: " + this.currentValue);
        System.out.println("NEW VALUE: " + entity.toString());
    }

    @PreRemove
    public void onPreDelete(TaskEntity entity) {
        System.out.println(entity.toString());
    }
}
