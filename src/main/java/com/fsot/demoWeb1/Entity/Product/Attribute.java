package com.fsot.demoWeb1.Entity.Product;

import com.fsot.demoWeb1.Entity.BasicEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Attribute")
public class Attribute extends BasicEntity {
    @Column(name = "name_Attribute")
    private String name_Attribute;

//    @ManyToMany
//    @JoinTable(name="Attribute_Value",
//    joinColumns = {@JoinColumn(name = "id_Attribute")},
//    inverseJoinColumns = {@JoinColumn(name = "id_Value")})
//    private List<Value> list_Value = new ArrayList<Value>();
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "Attribute_id")
    private  List<Value> list_value = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Product_Attribute",
    joinColumns = {@JoinColumn(name = "Attribute_Id")},
    inverseJoinColumns = {@JoinColumn(name = "Product_Id")})
    private List<ProductEntity> productEntityList = new ArrayList<>();

}
