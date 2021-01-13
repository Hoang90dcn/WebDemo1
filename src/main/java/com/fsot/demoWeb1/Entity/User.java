package com.fsot.demoWeb1.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "User")
public class User extends BasicEntity {
    @Column(name = "name")
    private String name;

    @Column(name = "accout")
    private String accout;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private List<RoleEntity> roles = new ArrayList<>();


    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<CommentEntity> listComment = new ArrayList<>();

    public List<RoleEntity> getRoles() {
        return roles;
    }
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<CartEntity> listCart = new ArrayList<>();
}
