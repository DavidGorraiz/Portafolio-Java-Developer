package com.dmgorraiz.task_manager_api.persistence.audit;

import com.dmgorraiz.task_manager_api.persistence.entity.AttachmentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.CommentEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;
import org.springframework.util.SerializationUtils;

public class AuditAttachmentListener {

    private AttachmentEntity currentValue;

    @PostLoad
    public void postLoad(AttachmentEntity attachment) {
        System.out.println("POST LOAD");
        this.currentValue = SerializationUtils.clone(attachment);
    }

    @PostPersist
    @PostUpdate
    public void onPostPersist(AttachmentEntity entity) {
        System.out.println("POST PERSIST OR UPDATE");
        System.out.println("OLD VALUE: " + this.currentValue);
        System.out.println("NEW VALUE: " + entity.toString());
    }

    @PreRemove
    public void onPreDelete(AttachmentEntity entity) {
        System.out.println(entity.toString());
    }
}
