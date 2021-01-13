package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Entity.CategoryEntity;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import com.fsot.demoWeb1.Repo.ProductRepo;
import com.fsot.demoWeb1.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ProdcutServiceImpl implements IProductService {
    @Autowired

    ProductRepo proRepo;
    @Override
    public ProductEntity saveProduct(ProductEntity product) {
        product.setStatus(true);
       product.setCreatedDate(new Date());
        return proRepo.save(product);
    }

    @Override
    public ProductEntity findById(Long id) {
        return proRepo.findById(id).get();
    }

    @Override
    public Page<ProductEntity> findAll(boolean status,int page ) {
        //Sort sort = Sort.by("price").descending();
        //Pageable pageable = PageRequest.of(page, 10,sort);
        Pageable pageable = PageRequest.of(page, 10);
        return proRepo.findAllByStatus(status, pageable);

    }

    @Override
    public Page<ProductEntity> findAllByCategory(Long id_category, int page) {
        Sort sort = Sort.by("price").descending();
        Pageable pageable = PageRequest.of(page, 10,sort);
        return proRepo.findAllProductByCategory(id_category, pageable);
    }


    @Override
    public Page<ProductEntity> findByKeyWord(String key, int page) {
        Sort sort = Sort.by("price").descending();
        Pageable pageable = PageRequest.of(page, 10,sort);
        return proRepo.findByKeyWord(key,pageable);
    }

    @Override
    public void deleteProduct(Long id) {
        ProductEntity productEntity = proRepo.findById(id).get();
        if(productEntity!=null)
        {
            productEntity.setStatus(false);
        }


    }


}
