package com.fsot.demoWeb1.API;

import com.fsot.demoWeb1.Auth.JWT.JwtTokenProvider;
import com.fsot.demoWeb1.Entity.CommentEntity;
import com.fsot.demoWeb1.Entity.User;
import com.fsot.demoWeb1.Service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api")
public class CommentAPI {
    @Autowired
    ICommentService service;

    @Autowired
    private JwtTokenProvider tokenProvider;

    @GetMapping("/find-all-comment")
    List<CommentEntity> findAll()
    {
        return service.FindAllComment();
    }

    @PostMapping("/save-comment")
    CommentEntity saveComment(@RequestParam Long id_product ,@RequestBody CommentEntity comment)
    {
        Long id_uer = 1l; //tokenProvider.getUserIdFromJWT(comment.getToken());
        User user = new User();
        System.out.println(id_uer);

        if(id_uer!=null)
        {
            user.setId(id_uer);
            comment.setUser(user);
            return service.PostComment(comment,id_product);
        }
      return null;
    }
    @GetMapping("/find-One-comment/{id}")
    public CommentEntity findById(@PathVariable Long id)
    {
        return  service.findById(id);
    }
    @GetMapping("find-all-comment-by-product")
    public Page<CommentEntity> findAllCommentByProduct(@RequestParam Long id_product,@RequestParam int page)
    {

        return service.findAllCommentByProduct(id_product,page);
    }
}
