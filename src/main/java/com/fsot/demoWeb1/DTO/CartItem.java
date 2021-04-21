package com.fsot.demoWeb1.DTO;


import lombok.Data;

@Data

public class CartItem {
    private Long id;
    private Long price;
    private Long amount;
    private String avatar;
    private String name;

}
