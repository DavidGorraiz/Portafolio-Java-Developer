package com.dmgorraiz.task_manager_api.domain.service;

import com.dmgorraiz.task_manager_api.persistence.crud.CrudBoardEntity;
import com.dmgorraiz.task_manager_api.persistence.crud.CrudUserEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.RoleEntity;
import com.dmgorraiz.task_manager_api.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserSecurityService implements UserDetailsService {

    private final CrudUserEntity crudUserEntity;

    @Autowired
    public UserSecurityService(CrudUserEntity crudUserEntity) {
        this.crudUserEntity = crudUserEntity;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = this.crudUserEntity.findFirstByUsername(username);

        if (userEntity == null){
            throw new UsernameNotFoundException(username);
        }

        System.out.println(userEntity);

        String[] roles = userEntity.getRoles().stream().map(RoleEntity::getRole).toArray(String[]::new);

        return User.builder()
                .username(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(grantedAuthorities(roles))
                .accountLocked(userEntity.getLocked())
                .disabled(userEntity.getDisabled())
                .build();
    }

    private String[] getAthorities(String role) {
        if ("ADMIN".equals(role) || "USER".equals(role) || "READER".equals(role)) {
            return new String[] {"summer_task"};
        }

        return new String[] {};
    }

    private List<GrantedAuthority> grantedAuthorities(String[] roles) {
        List<GrantedAuthority> authorities = new ArrayList<>(roles.length);

        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));

            for (String authority : getAthorities(role)) {
                authorities.add(new SimpleGrantedAuthority(authority));
            }
        }

        return authorities;
    }
}
