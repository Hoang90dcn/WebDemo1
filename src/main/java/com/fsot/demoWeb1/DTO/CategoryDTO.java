package com.fsot.demoWeb1.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CategoryDTO extends  BasicDTO {
    private  String name;
    private  String description;
    private  String icon;
    private List<ProductDTO> myListProduct = new ArrayList<>();

}
