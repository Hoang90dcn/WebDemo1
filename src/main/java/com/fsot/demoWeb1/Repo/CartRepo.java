package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.CartEntity;
import com.fsot.demoWeb1.Entity.DetailOder;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepo extends JpaRepository<CartEntity, Long> {
    @Query(value = "select * from demoweb1.oder order by  demoweb1.oder.confirm, demoweb1.oder.status desc," +
            " demoweb1.oder.createdDate desc",nativeQuery = true)
    List<CartEntity> findAllNewCart();
//    Pageable pageable  SELECT * FROM demoweb1.oder where confirm = 0
}
