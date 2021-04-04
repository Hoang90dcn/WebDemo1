package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.Entity.CategoryEntity;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import com.fsot.demoWeb1.Repo.ProductRepo;
import com.fsot.demoWeb1.Service.IProductService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@Service
public class ProdcutServiceImpl implements IProductService {
    @Autowired

    ProductRepo proRepo;
    @Override
    public ProductEntity saveProduct(String productDTO, Long category_id, MultipartFile file) {


        Gson gson = new Gson();
        ProductEntity product = gson.fromJson(productDTO,ProductEntity.class);
        MultipartFile multipartFile = file;
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd_MMM_yyyy_HH_mm_ss");



        if(product.getId()!=null)
        {
           ProductEntity oldProduct = proRepo.findById(product.getId()).get();
           product.setModifiedDate(date);
           if(oldProduct.getAvatar()!=null)
           {
               Path filePath = Paths.get("D:\\JAVA_FPT\\demoWeb1\\upload\\"+ oldProduct.getAvatar());
               try {
                   System.out.println(filePath);
                   Files.delete(filePath);

               }catch (Exception e)
               {
                   System.out.println(e);
               }
           }

        }


        if(!file.isEmpty())
        {


            try {
                String fileName = df.format(date)+"_"+multipartFile.getOriginalFilename();
                String path = "D:\\JAVA_FPT\\demoWeb1\\upload\\products\\" + fileName;
                file.transferTo(new File(path));
                product.setAvatar("products/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        product.setStatus(true);
        product.setCreatedDate(new Date());
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category_id);
        product.setCategories(categoryEntity);

        return proRepo.save(product);


    }
    @Override
    public ProductEntity findById(Long id) {
        return proRepo.findById(id).get();
    }

    @Override
    public Page<ProductEntity> findAllByStatus(boolean status,int page ) {

        Pageable pageable = PageRequest.of(page, 10);
        return proRepo.findAllByStatus(status, pageable);

    }

    @Override
    public Page<ProductEntity> findAllByCategory(Long id_category, int page) {
        Sort sort = Sort.by("Price").descending();
        Pageable pageable = PageRequest.of(page, 10,sort);
        return proRepo.findAllProductByCategory(id_category, pageable);
    }


    @Override
    public Page<ProductEntity> findByKeyWord(String key, int page) {
        Sort sort = Sort.by("Price").descending();
        Pageable pageable = PageRequest.of(page, 10,sort);
        return proRepo.findByKeyWord(key,pageable);
    }

    @Override
    public ArrayList<ProductEntity> findAll() {
        return (ArrayList<ProductEntity>) proRepo.findAll();
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
