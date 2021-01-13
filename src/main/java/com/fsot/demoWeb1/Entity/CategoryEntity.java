package com.fsot.demoWeb1.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Category")
public class CategoryEntity  extends  BasicEntity{
    @Column(name="name", nullable = false)
    private  String name;

    @Column(name = "Description")
    private  String description;

    @Column(name = "icon")
    private  String icon;

    @JsonIgnore
    @OneToMany(mappedBy = "categories")
    private List<ProductEntity> myListProduct = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="id_parent")
    private CategoryEntity id_parent;

}
