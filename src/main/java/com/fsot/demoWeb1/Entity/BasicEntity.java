package com.fsot.demoWeb1.Entity;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Data
@MappedSuperclass

public abstract class BasicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "createdBy")
    private String createdBy;

    @Column(name = "createdDate")
    private Date createdDate = new Date();

    @Column(name = "modifiedBy")
    private String modifiedBy;

    @Column(name = "modifiedDate")

    private Date modifiedDate;

    @Column(name = "status",columnDefinition = "TINYINT", nullable=true)
    private boolean status = true;

}
