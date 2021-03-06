package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.DTO.ResponEntity;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import com.fsot.demoWeb1.Service.IKeyWordService;
import com.fsot.demoWeb1.Service.IProductService;
import net.bytebuddy.asm.Advice;
import org.hibernate.HibernateError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ProductAPI {
    @Autowired
    IProductService service;

    @Autowired IProductService service2;

    @Autowired
    IKeyWordService repo;

    @GetMapping("/test")
    public String test()
    {
        return "test";
    }

//    @GetMapping("/find-all-product")
//    public Page<ProductEntity> findAll(@RequestParam int page)
//    {
//        return service.findAll(page);
//    }
//
//
//    @GetMapping("/find-one/{id}")
//
//    public ResponseEntity findById(@PathVariable Long id)
//    {
//        try {
//             ProductEntity productEntity = service.findById(id);
//            return  ResponseEntity.ok().body(productEntity);
//        }catch (NoSuchElementException e) {
//            return ResponseEntity.badRequest().body((new ResponEntity("Không tìm thấy sản phẩm", 500)));
//
//        }
//    }
//
//    @GetMapping("/find-all-by-category")
//    public Page<ProductEntity>  findAllByCategory(@RequestParam Long id_category,@RequestParam int page )
//    {
//        return service.findAllByCategory(id_category, page);
//    }
//
//    @GetMapping("/test3")
//    public Page<ProductEntity> test3(@RequestParam String key, @RequestParam int page)
//    {
//
//        return service.findByKeyWord(key,page);
//    }

}
