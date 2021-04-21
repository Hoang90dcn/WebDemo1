package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@Service
public interface IProductService {
    ProductEntity saveProduct(String productDTO, Long category_id, MultipartFile avatar, Long provider_id);
    ProductEntity findById(Long id);
    Page<ProductEntity> findAllByStatus(boolean status,int page);
    Page<ProductEntity> findAllByCategory(Long id_category, int page);
    Page<ProductEntity> findByKeyWord(String key, int page);
    ArrayList<ProductEntity> findAll();
    void deleteProduct(Long id);
}
