package com.fsot.demoWeb1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Comment")
public class CommentEntity  extends  BasicEntity{
    @Column(name = "content",columnDefinition = "TEXT")
    private  String content;


    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_Id")
    private  User user;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_Id")
    private ProductEntity product;

    @Transient
    private String user_name ;

    @Transient
    private String token;



}
