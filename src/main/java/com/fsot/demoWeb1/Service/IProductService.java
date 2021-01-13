package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface IProductService {
    ProductEntity saveProduct(ProductEntity product);
    ProductEntity findById(Long id);
    Page<ProductEntity> findAll(boolean status,int page);
    Page<ProductEntity> findAllByCategory(Long id_category, int page);
    Page<ProductEntity> findByKeyWord(String key, int page);
    void deleteProduct(Long id);
}
