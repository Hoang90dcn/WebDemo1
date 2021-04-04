package com.fsot.demoWeb1.DTO;

import lombok.Data;

import java.util.Date;
@Data
public class BasicDTO {
    private Long id;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;
    private boolean status;
}
