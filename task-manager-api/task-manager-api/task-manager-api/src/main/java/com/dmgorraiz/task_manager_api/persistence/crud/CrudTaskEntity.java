package com.dmgorraiz.task_manager_api.persistence.crud;

import com.dmgorraiz.task_manager_api.persistence.entity.TaskEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CrudTaskEntity extends CrudRepository<TaskEntity, Long> {
    @Query("""
                SELECT t FROM TaskEntity t JOIN t.board b JOIN b.owner u WHERE u.username = :username 
            """)
    List<TaskEntity> findTasksByUsername(@Param("username") String username);
}
