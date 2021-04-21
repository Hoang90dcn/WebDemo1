package com.fsot.demoWeb1.Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "AdministrativeUnits")
public class AdministrativeUnits extends BasicEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "Code")
    private String Code;

    @OneToOne
    @JoinColumn(name="parent_id")
    private AdministrativeUnits parent_id;



}
