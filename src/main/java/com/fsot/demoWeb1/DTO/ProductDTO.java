package com.fsot.demoWeb1.DTO;

import lombok.Data;

@Data
public class ProductDTO extends BasicDTO {
    private String name;
    private String description;
    private String avatar;
    private  Long price;



    public ProductDTO(String name, String description, String avatar, Long price ) {
        this.name = name;
        this.description = description;
        this.avatar = avatar;
        this.price = price;

    }
}
