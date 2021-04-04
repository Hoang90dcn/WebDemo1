package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.CategoryEntity;
import com.fsot.demoWeb1.Entity.DetailOder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<CategoryEntity, Long> {
    @Query(value = "select * from category where parent_id=1",nativeQuery = true)
    List<CategoryEntity> findAllDefault();

}
