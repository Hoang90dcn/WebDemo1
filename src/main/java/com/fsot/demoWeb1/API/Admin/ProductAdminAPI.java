package com.fsot.demoWeb1.API.Admin;

import com.fsot.demoWeb1.DTO.ResponEntity;
import com.fsot.demoWeb1.Entity.CategoryEntity;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import com.fsot.demoWeb1.Repo.ProductRepo;
import com.fsot.demoWeb1.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@CrossOrigin
@RestController
@RequestMapping("/api/admin")
public class ProductAdminAPI {
    @Autowired
    private IProductService service2;

    @Autowired ProductRepo productRepo;

    @GetMapping("/find-all-product")
    public ResponseEntity findAll()
    {
        try {
            ArrayList<ProductEntity> list = service2.findAll();
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





    // lưu sản phẩm
    @PostMapping("/save-product")
    public ResponseEntity saveData(@RequestBody ProductEntity entity, @RequestParam Long category_id)
    {
        try{
//           if(file.isEmpty())
//           {
//               return  ResponseEntity.status(HttpStatus.CREATED).body(new ResponEntity("Lưu không thành công",401));
//           }
          //String fullpart = "D:\\JAVA_FPT\\demoWeb1\\image\\product\\"+file.getOriginalFilename();
           //entity.setAvatar(fullpart);
           //file.transferTo(new File(fullpart));
           //service2.saveProduct(entity,category_id);
            return  ResponseEntity.ok().body(new ResponEntity("Lưu  thành công",200));
        }
        catch (Exception e)
        {
            return ResponseEntity.badRequest().body(new ResponEntity("Lưu không thành công",400));
        }
    }

    @PostMapping(value = "/save-test-product")
    public ResponseEntity saveData2(@RequestParam("product") String productDTO,
                                    @RequestParam("file") MultipartFile file,
                                    @RequestParam Long category_id,
                                    @RequestParam Long provider_id
    )
    {
        System.out.println(provider_id);
        try{
            service2.saveProduct(productDTO,category_id,file,provider_id);
            return  ResponseEntity.ok().body(new ResponEntity("Lưu  thành công",200));
        }
        catch (Exception e)
        {
            System.out.println(e);
            return ResponseEntity.badRequest().body(new ResponEntity("Lưu không thành công",400));
        }

    }
    @DeleteMapping("/delete-product")
    public ResponseEntity DELETE(@RequestParam Long product_id)
    {
        try{
            service2.deleteProduct(product_id);
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


    @PostMapping(value = "/test-file-up-load")
    public ResponseEntity testfile(@RequestParam("file") MultipartFile file)
    {
        if(!file.isEmpty())
        {
            System.out.println("ok");
        }
       return  null;
    }
}
