package com.fsot.demoWeb1.Entity.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsot.demoWeb1.Entity.*;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Product")
public class ProductEntity extends BasicEntity {
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "avatar")
    private String avatar;



    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "Category_Id")
    private CategoryEntity categories;


//    @JsonIgnore
    @OneToMany(mappedBy = "user", fetch =  FetchType.LAZY)
    private List<CommentEntity> listComment = new ArrayList<>();





//    @JsonIgnore
    @OneToMany(mappedBy = "producst", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<DetailOder> listDetailOrders = new ArrayList<>();

//    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Product_Attribute",
    joinColumns = {@JoinColumn(name = "Product_Id")},
    inverseJoinColumns = {@JoinColumn(name = "Attribute_Id")})
    private List<Attribute> list_Attribute = new ArrayList<>();

//    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "Provider_Id")
    private ProviderEntity provider ;


    @Column(name = "Price")
    private Long Price;

    @Column(name = "deal")
    private Long deal;


//    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private Advertisement advertisement_id;

//    @JsonIgnore
    @OneToMany(mappedBy = "product_Id", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private  List<Image_ProductEntity> list_image = new ArrayList<>();




    @Column(name = "description", columnDefinition = "TEXT")
    private String description;


    @Column(name = "rating")
    private double rating;

//    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    @JoinTable(name = "key_product",
//            joinColumns = {@JoinColumn(name = "product_id")},
//            inverseJoinColumns = {@JoinColumn(name = "key_id") }
//    )
//    private List<KeyWordEntitySearch> key_product = new ArrayList<>();

}
