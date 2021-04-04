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

    @Column(name = "description")
    private  String description;

    @Column(name = "icon")
    private  String icon;

    @OneToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<ProductEntity> myListProduct = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="parent_id")
    private CategoryEntity id_parent;

}
