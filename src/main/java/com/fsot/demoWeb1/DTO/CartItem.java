package com.fsot.demoWeb1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class CartItem {
    private Long productId;
    private Long price;
    private Long quantity;
    private String avatar;
    private  String thumnail;
    private Long totalMoney;
    private String productName;

}
