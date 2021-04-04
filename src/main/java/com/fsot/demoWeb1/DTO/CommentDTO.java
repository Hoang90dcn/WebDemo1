package com.fsot.demoWeb1.DTO;

import lombok.Data;

@Data
public class CommentDTO extends BasicDTO {
    private  String content;
    private  String fullName;
    private String Date;

}
