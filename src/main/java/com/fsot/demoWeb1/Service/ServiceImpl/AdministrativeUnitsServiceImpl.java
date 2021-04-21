package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Entity.AdministrativeUnits;
import com.fsot.demoWeb1.Repo.AdministrativeUnitsRepo;
import com.fsot.demoWeb1.Service.IAdministrativeUnitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministrativeUnitsServiceImpl implements IAdministrativeUnitsService {

    @Autowired
    AdministrativeUnitsRepo service;
    @Override
    public List<AdministrativeUnits> findAllByParentId(Long parent_id) {
        System.out.println(parent_id);
        return service.findAllByParentId(parent_id);
        //return null;
    }

    @Override
    public List<AdministrativeUnits> saveAll(List<AdministrativeUnits> list, Long parent_id) {
        AdministrativeUnits parent = new AdministrativeUnits();
        parent.setId(parent_id);
        for(AdministrativeUnits item : list)
        {
            item.setParent_id(parent);
            service.save(item);
        }
        return list;
    }
}
