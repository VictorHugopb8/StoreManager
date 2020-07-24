package com.store.manager.storemanager.product;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String barCode;
    private String name;
    private BigDecimal value;

    @Override
    public String toString() {
        return String.format(
                "Product[" +
                        "id=%d, " +
                        "barCode=%s, " +
                        "name=%s, " +
                        "value=%f" +
                        "]",
                this.id,
                this.getBarCode(),
                this.getName(),
                this.getValue());
    }

}
