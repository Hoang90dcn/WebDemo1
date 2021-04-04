package com.fsot.demoWeb1.Entity;

import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Table(name = "Image_Product")
@Entity
@Data

public class Image_ProductEntity extends  BasicEntity{
    @Column(name = "link")
    private String link;

    @ManyToOne(fetch = FetchType.EAGER)
    private ProductEntity product_Id ;

//    @ManyToOne(fetch = FetchType.EAGER)
//    private Advertisement advertisement_id;
}
