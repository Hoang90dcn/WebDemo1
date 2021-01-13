package com.fsot.demoWeb1.Entity.Product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsot.demoWeb1.Entity.*;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
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



    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Category_Id")
    private CategoryEntity categories;


    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<CommentEntity> listComment = new ArrayList<>();


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "key_product",
            joinColumns = {@JoinColumn(name = "product_id")},
            inverseJoinColumns = {@JoinColumn(name = "key_id") }
    )
    private List<KeyWordEntitySearch> key_product = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "producst", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<DetailOder> listDetailOders = new ArrayList<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "Product_Attribute",
    joinColumns = {@JoinColumn(name = "id_Product")},
    inverseJoinColumns = {@JoinColumn(name = "id_Attribute")})
    private List<Attribute> list_Attribute = new ArrayList<>();

}
