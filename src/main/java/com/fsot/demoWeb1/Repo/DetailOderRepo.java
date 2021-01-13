package com.fsot.demoWeb1.Repo;


import com.fsot.demoWeb1.Entity.DetailOder;
import com.fsot.demoWeb1.Entity.DetaliOderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailOderRepo extends JpaRepository<DetailOder, DetaliOderId> {
    @Query(value = "SELECT * FROM demoweb1.tbl_detail_oder where id_oder=?1",nativeQuery = true)
    List<DetailOder> findAllByIdCart(Long id);

}
