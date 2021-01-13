package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Entity.RoleEntity;
import com.fsot.demoWeb1.Repo.RoleRepo;
import com.fsot.demoWeb1.Service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl  implements IRoleService {

    @Autowired
    RoleRepo service;
    @Override
    public RoleEntity save(RoleEntity entity) {
        return service.save(entity);
    }

    @Override
    public RoleEntity findOne(Long id) {
        return service.findById(id).get();
    }

    @Override
    public List<RoleEntity> findAll() {
        return service.findAll();
    }
}
