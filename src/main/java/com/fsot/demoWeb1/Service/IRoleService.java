package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.RoleEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IRoleService {
    RoleEntity save(RoleEntity entity);
    RoleEntity findOne(Long id);
    List<RoleEntity> findAll();
}
