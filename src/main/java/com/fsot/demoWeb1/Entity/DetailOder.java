package com.fsot.demoWeb1.Entity;

import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "detail_Oder")
public class DetailOder {

    @EmbeddedId
    DetaliOderId id;

    @ManyToOne
    @MapsId("oder_ID")
    @JoinColumn(name = "oder_id")
    private CartEntity oder;// id của giỏ hàng

    @ManyToOne
    @MapsId("product_ID")
    @JoinColumn(name = "product_id")
    private ProductEntity producst; // id của sản phẩm



    @Column(name = "amount")
    private Long amount;


    @Column(name = "price")
    private Long price;
    

    public DetailOder() {
        super();
        // TODO Auto-generated constructor stub
    }


    public DetailOder(CartEntity oder, ProductEntity product, Long amount) {
        this.id = new DetaliOderId(oder.getId(),product.getId());
        System.out.println(oder.getId());
        System.out.println(product.getId());
        this.oder = oder;
        this.producst = product;
        this.amount = amount;
    }
}
