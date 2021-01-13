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
    @Query(value = "SELECT * FROM demoweb1.cart where confirm = 0",nativeQuery = true)
    List<CartEntity> findAllNewCart(Pageable pageable);
}
