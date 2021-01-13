package com.fsot.demoWeb1.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@AllArgsConstructor
public class ResponEntity implements Serializable {


    private String message;
    private int statusCode;

}
