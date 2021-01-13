package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.CategoryEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService {

    CategoryEntity findById(Long id);
    List<CategoryEntity> findAll();
    List<CategoryEntity> saveAll(List<CategoryEntity> list);
    CategoryEntity add_Category(CategoryEntity categoey);


}
