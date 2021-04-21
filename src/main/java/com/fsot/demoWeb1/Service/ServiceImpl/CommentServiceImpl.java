package com.fsot.demoWeb1.Service.ServiceImpl;

import com.fsot.demoWeb1.DTO.CommentDTO;
import com.fsot.demoWeb1.Entity.CommentEntity;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import com.fsot.demoWeb1.Repo.CommentRepo;
import com.fsot.demoWeb1.Service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService {
    @Autowired
    CommentRepo service;


    @Override
    public CommentEntity PostComment(CommentEntity comment, Long id_product) {
        comment.setCreatedDate(new Date());
        ProductEntity pro = new ProductEntity();
        pro.setId(id_product);
        comment.setProduct(pro);
        return service.save(comment);
    }

    @Override
    public List<CommentEntity> FindAllComment() {
        return service.findAll();
    }

    @Override
    public List<CommentEntity> findByIdProduct(Long id) {

        return null;

    }

    @Override
    public CommentEntity findById(Long id) {
        return service.findById(id).get();
    }

    @Override
    public Page<CommentEntity> findAllCommentByProduct(Long id_product, int page) {
        Sort sort = Sort.by("createdDate").descending();
        Pageable pageable = PageRequest.of(page, 10,sort);
        Page<CommentEntity> page1 =service.findAllProductByCategory(id_product,pageable);
        //List<CommentDTO> list = new ArrayList<>();
        for(CommentEntity item : page1)
        {
            item.setUser_name("Huy Hoàng");
//            list.add(new CommentDTO(item.g));
        }
        return service.findAllProductByCategory(id_product,pageable);
    }
}
