package com.fsot.demoWeb1.API.Admin;

import com.fsot.demoWeb1.DTO.ResponEntity;
import com.fsot.demoWeb1.Entity.CategoryEntity;
import com.fsot.demoWeb1.Service.ServiceImpl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@CrossOrigin

public class CategoryAPI {
    private  @Autowired
    CategoryServiceImpl service;
    @PostMapping("/add-Category")
    public ResponseEntity add_Category(@RequestBody CategoryEntity entity)
    {
       try {
           CategoryEntity categoryEntity = service.add_Category(entity);
           return ResponseEntity.ok().body(new ResponEntity("Lưu không thành công",200) );
       }
       catch (Exception e)
       {
           return ResponseEntity.status(500).body(new ResponEntity("Lưu không thành công",500)) ;
       }
    }

    @GetMapping("/find-all-category")

    public ResponseEntity find_all(){
        List<CategoryEntity> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
