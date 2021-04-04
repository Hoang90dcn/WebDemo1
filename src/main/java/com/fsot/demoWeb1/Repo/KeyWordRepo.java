package com.fsot.demoWeb1.Repo;

import com.fsot.demoWeb1.Entity.KeyWordEntitySearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface KeyWordRepo  {
//extends JpaRepository<KeyWordEntitySearch, Long>
//    @Query(value = "SELECT * FROM demoweb1.key_word_search where keyword=?1", nativeQuery = true)
//    List<KeyWordEntitySearch> findAllIdProduct(String key);
}
