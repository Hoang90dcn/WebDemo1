package com.fsot.demoWeb1.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Role")
@Data
public class RoleEntity extends BasicEntity {
    @Column(name = "name")
    private  String name;

    @Column(name = "description")
    private  String description;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role",
            joinColumns = { @JoinColumn(name = "role_id") },
            inverseJoinColumns = {@JoinColumn(name = "user_id") })
    private List<User> users = new ArrayList();


}
