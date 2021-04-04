package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends  JpaRepository<User, Long>{
    @Query(value = "select u from User u where account=?1")
    User checkLogin(String account);
}
