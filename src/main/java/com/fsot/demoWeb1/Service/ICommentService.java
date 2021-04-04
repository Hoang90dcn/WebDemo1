package com.fsot.demoWeb1.Service;

import com.fsot.demoWeb1.Entity.CommentEntity;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICommentService {
    CommentEntity PostComment(CommentEntity comment, Long id_product);
    List<CommentEntity> FindAllComment();
    List<CommentEntity> findByIdProduct(Long id);
    CommentEntity findById(Long id);
    Page<CommentEntity> findAllCommentByProduct(Long id_product, int page);

}
