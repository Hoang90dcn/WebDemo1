package com.fsot.demoWeb1.Entity;


import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Date;
import  java.util.ArrayList;
import java.util.List;

@Table(name = "Advertisement")
@Entity
@Data
public class Advertisement extends BasicEntity {
    @Column(name = "Start_Date")
    private Date start_Date;

    @Column(name = "End_Date")
    private Date end_Date;

    @Column(name ="Banner")
    private String banner;

    @OneToMany(mappedBy = "advertisement_id")
    private List<ProductEntity> list_product = new ArrayList<>();

}
