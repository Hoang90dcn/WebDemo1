package com.fsot.demoWeb1.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "KeyWordSearch")
public class KeyWordEntitySearch extends  BasicEntity {
    @Column(name = "keyword")
    private  String key;

    @Column(name = "product_id")
    private Long product_id;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "key_product",
            joinColumns = {@JoinColumn(name = "key_id")},
            inverseJoinColumns = {@JoinColumn(name = "product_id") }
    )
    private List<KeyWordEntitySearch> key_product = new ArrayList<>();



}
