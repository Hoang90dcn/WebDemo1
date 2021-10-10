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
    public List<CategoryEntity> findAll(Long id) {
        return categoryRepo.findAllDefault(id);
    }

    @Override
    public List<CategoryEntity> findAllDefaultWithStatus(Long id) {
        return categoryRepo.findAllDefaultWithStatus(id);
    }

    @Override
    public List<CategoryEntity> saveAll(List<CategoryEntity> list) {
        return categoryRepo.saveAll(list);
    }

    @Override
    public CategoryEntity add_Category(CategoryEntity category) {
        if(category.getId()!=null)
        {
            category.setModifiedDate(new Date());
            return categoryRepo.save(category);
        }
        category.setStatus(true);
        return categoryRepo.save(category);
    }

    @Override
    public CategoryEntity updateStatus(Long id) {
        CategoryEntity categoryEntity = categoryRepo.findById(id).get();
        categoryEntity.setStatus(!categoryEntity.isStatus());
        categoryRepo.save(categoryEntity);


        return categoryRepo.save(categoryEntity);
    }

    @Override
    public CategoryEntity updateCategory(Long id) {
        return null;
    }

}
