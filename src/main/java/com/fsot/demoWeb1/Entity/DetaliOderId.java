package com.fsot.demoWeb1.Entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Data
@Embeddable
public class DetaliOderId implements Serializable {


    @Column(name = "id_oder")
    private Long oder_ID;

    @Column(name = "id_producst")
    private Long product_ID;

    public DetaliOderId() {
    }

    public DetaliOderId(Long oder_ID, Long product_ID) {
        this.oder_ID = oder_ID;
        this.product_ID = product_ID;
    }
}
