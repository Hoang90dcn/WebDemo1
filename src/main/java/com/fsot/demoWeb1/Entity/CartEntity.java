package com.fsot.demoWeb1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Oder")
public class CartEntity extends  BasicEntity {

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_Id")
    private  User user;

    @Column(name = "total")
    private Long total;

    @Column(name = "confirm")
    private Boolean confirm;

    @Column(name = "address",columnDefinition = "TEXT")
    private  String address;

    @JsonIgnore
    @OneToMany(mappedBy = "oder")
    private List<DetailOder> listDetailOders = new ArrayList<>();


}
