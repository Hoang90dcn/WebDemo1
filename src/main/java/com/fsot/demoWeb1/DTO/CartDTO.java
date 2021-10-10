package com.fsot.demoWeb1.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CartDTO extends  BasicDTO{
    private Long total;
    private UserDTO user;
    private Boolean confirm;
    private  String address;
    List<DetailOderDTO> listDetailOders = new ArrayList<>();

}
