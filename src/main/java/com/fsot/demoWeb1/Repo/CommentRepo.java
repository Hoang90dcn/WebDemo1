package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
@Repository

public interface CommentRepo extends  JpaRepository<CommentEntity, Long> {
    @Query(value = "select * from demoweb1.comment where product_id =?1",nativeQuery = true)
    Page<CommentEntity> findAllProductByCategory(Long id_category, Pageable pageable);
}
