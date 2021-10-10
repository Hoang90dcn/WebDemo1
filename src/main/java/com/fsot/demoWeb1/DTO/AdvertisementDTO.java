package com.fsot.demoWeb1.DTO;

import com.fsot.demoWeb1.Entity.Product.ProductEntity;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class AdvertisementDTO extends BasicDTO {
    private Date start_Date;
    private Date end_Date;
    private String banner;
    private List<ProductDTO> list_product = new ArrayList<>();
}
