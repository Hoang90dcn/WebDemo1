package com.fsot.demoWeb1.Entity;

import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import javax.persistence.*;
@Data
@Entity
@Table(name = "tbl_detail_oder")
public class DetailOder {

    @EmbeddedId
    DetaliOderId id;

    @ManyToOne
    @MapsId("oder_ID")
    @JoinColumn(name = "id_oder")
    private CartEntity oder;// id của giỏ hàng

    @ManyToOne
    @MapsId("product_ID")
    @JoinColumn(name = "id_producst")
    private ProductEntity producst; // id của sản phẩm



    @Column(name = "amount")
    private Long amount;



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
