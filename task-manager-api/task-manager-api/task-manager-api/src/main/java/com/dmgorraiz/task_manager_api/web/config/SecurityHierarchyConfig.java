package com.dmgorraiz.task_manager_api.web.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.hierarchicalroles.RoleHierarchy;
import org.springframework.security.access.hierarchicalroles.RoleHierarchyImpl;

@Configuration
public class SecurityHierarchyConfig {

    @Bean
    public RoleHierarchy roleHierarchy() {
        RoleHierarchyImpl roleHierarchy = new RoleHierarchyImpl();

        String hierarchy = """
        ROLE_ADMIN > ROLE_OWNER
        ROLE_OWNER > ROLE_MANAGER
        ROLE_MANAGER > ROLE_DEVELOPER
        ROLE_DEVELOPER > ROLE_USER
        ROLE_USER > ROLE_MODERATOR
        ROLE_USER > ROLE_TESTER
        ROLE_USER > ROLE_DESIGNER
        ROLE_USER > ROLE_VIEWER
        ROLE_VIEWER > ROLE_READER
        ROLE_READER > ROLE_GUEST
        """;

        roleHierarchy.setHierarchy(hierarchy);
        return roleHierarchy;
    }
}
