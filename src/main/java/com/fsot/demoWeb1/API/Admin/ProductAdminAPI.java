package com.fsot.demoWeb1.API.Admin;

import com.fsot.demoWeb1.DTO.ResponEntity;
import com.fsot.demoWeb1.Entity.CategoryEntity;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import com.fsot.demoWeb1.Repo.ProductRepo;
import com.fsot.demoWeb1.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class ProductAdminAPI {
    @Autowired
    private IProductService service2;

    @GetMapping("/find-all-product")
    public ResponseEntity findAll(@RequestParam boolean status,@RequestParam int page)
    {
        try {
            Page<ProductEntity> list = service2.findAll(status,page);
            if(!list.isEmpty())
            {
                return  ResponseEntity.ok().body(list);
            }
            else
            {
                return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("Không tìm thấy trang");
            }
        }
        catch (Exception e)
        {
            return  ResponseEntity.badRequest().body(new ResponEntity("Đã xảy ra lỗi",500));
        }

    }
    @GetMapping("/get-id-catgory")
    public CategoryEntity findAll(@RequestParam Long id)
    {
        return  null;
    }
    @PostMapping("/save-product")
    public ResponseEntity saveData(@RequestBody ProductEntity entity)
    {
        try{
//           if(file.isEmpty())
//           {
//               return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponEntity("Lưu không thành công",401));
//           }
          //String fullpart = "D:\\JAVA_FPT\\demoWeb1\\image\\product\\"+file.getOriginalFilename();
           //entity.setAvatar(fullpart);
           //file.transferTo(new File(fullpart));
           service2.saveProduct(entity);
            return  ResponseEntity.ok().body(new ResponEntity("Lưu  thành công",401));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(new ResponEntity("Lưu không thành công",400));
        }
    }
    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity DELETE(@PathVariable Long id)
    {
        try{
            service2.deleteProduct(id);
            return  ResponseEntity.ok().body(new ResponEntity("Xoá Thành Công!!!",200));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(new ResponEntity("Xóa Không Thành Công",400));
        }
    }

    @PutMapping("/update-product/{id_category}")
    public void update(@PathVariable Long id_category, @RequestBody ProductEntity entity)
    {
        System.out.println(entity.getId());
        System.out.println(entity.getName());
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(id_category);
        entity.setCategories(categoryEntity);
        //service.save(entity);
    }
}
