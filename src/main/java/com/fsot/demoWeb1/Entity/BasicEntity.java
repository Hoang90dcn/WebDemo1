package com.fsot.demoWeb1.Entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.util.Date;


@Data
@MappedSuperclass

public abstract class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String createdBy;

    @Column

    private Date createdDate = new Date();

    @Column
    private String modifiedBy;

    @Column

    private Date modifiedDate;

    @Column(columnDefinition = "TINYINT")
    private boolean status;

}
