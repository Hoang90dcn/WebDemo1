package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Entity.CategoryEntity;
import com.fsot.demoWeb1.Repo.CategoryRepo;
import com.fsot.demoWeb1.Service.ICategoryService;
import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {
    @Autowired
    CategoryRepo categoryRepo;
    @Override
    public CategoryEntity findById(Long id) {
        return categoryRepo.findById(id).get();
    }
    @Override
    public List<CategoryEntity> findAll() {
        return categoryRepo.findAllDefault();
    }
    @Override
    public List<CategoryEntity> saveAll(List<CategoryEntity> list) {
        return categoryRepo.saveAll(list);
    }

    @Override
    public CategoryEntity add_Category(CategoryEntity category) {
        category.setStatus(true);
        return categoryRepo.save(category);
    }
}
