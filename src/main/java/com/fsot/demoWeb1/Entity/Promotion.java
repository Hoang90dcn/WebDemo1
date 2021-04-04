package com.fsot.demoWeb1.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "Promotion")
@Entity
@Data
public class Promotion extends BasicEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Percent")
    private  String percent;

    @Column(name = "Start_Date")
    private Date start_Date;

    @Column(name = "End_Date")
    private Date end_Date;


    @Column(name = "Code")
    private String code;
}
