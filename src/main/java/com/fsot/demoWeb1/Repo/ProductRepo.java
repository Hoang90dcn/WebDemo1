package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    @Query(value = "select * from product where category_id =?1",nativeQuery = true)
    Page<ProductEntity> findAllProductByCategory(Long id_category, Pageable pageable);

    @Query(value = "select * from product where name like %:key%",nativeQuery = true)
    Page<ProductEntity> findByKeyWord(@Param("key") String key, Pageable pageable);

//    @Query("SELECT m FROM Movie m WHERE m.title LIKE %:title%")
//    List<ProductEntity> searchByTitleLike(@Param("title") String title);


   // Sort sort = Sort.by("name").descending();
   @Query(value = "select * from product where status = ?1",nativeQuery = true)
   Page<ProductEntity> findAllByStatus( boolean status, Pageable pageable);
}
