package com.fsot.demoWeb1.Entity.Product;

import com.fsot.demoWeb1.Entity.BasicEntity;
import lombok.Data;
import org.aspectj.weaver.NameMangler;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "Value")
public class Value extends BasicEntity {
    @Column(name = "value_Attribute")
    private String value_Attribute;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "Attribute_Value",
    joinColumns = {@JoinColumn(name = "id_Value")},
    inverseJoinColumns = {@JoinColumn(name = "id_Attribute")})
    private List<Attribute> list_Attribute = new ArrayList<>();
}
