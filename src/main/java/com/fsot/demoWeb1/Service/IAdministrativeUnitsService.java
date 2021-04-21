package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.AdministrativeUnits;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface IAdministrativeUnitsService {
     List<AdministrativeUnits> findAllByParentId(Long parent_id);
     List<AdministrativeUnits> saveAll(List<AdministrativeUnits> list, Long parent_id);
}
