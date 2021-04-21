package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.AdministrativeUnits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdministrativeUnitsRepo extends JpaRepository<AdministrativeUnits,Long> {
    @Query(value = "select * from administrativeunits where parent_id=?1",nativeQuery = true)
    List<AdministrativeUnits> findAllByParentId(Long parent_id);
}
