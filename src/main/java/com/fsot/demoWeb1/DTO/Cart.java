package com.fsot.demoWeb1.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Cart {

    private  String address;
    private List<CartItem> list = new ArrayList<CartItem>();
    private Long tatol = new Long(0);

    public List<CartItem> getList() {
        return list;
    }

    public void setList(List<CartItem> list) {
        this.list = list;
    }

    public Long getTatol() {
        return tatol;
    }

    public void setTatol(Long tatol) {
        this.tatol = tatol;
    }
}
