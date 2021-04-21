package com.fsot.demoWeb1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "Provider")
@Data
public class ProviderEntity extends  BasicEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "logo", columnDefinition = "TEXT")
    private String logo;

    @JsonIgnore
    @OneToMany(mappedBy = "provider", fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
    private List<ProductEntity> list_Product = new ArrayList<>();
}
