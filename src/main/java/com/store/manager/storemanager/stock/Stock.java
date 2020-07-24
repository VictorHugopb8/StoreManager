package com.store.manager.storemanager.stock;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private long productId;
    private long quantity;
    private boolean hasStock;

    @Override
    public String toString() {
        return String.format(
                "Stock[" +
                        "id=%d, " +
                        "productId=%d, " +
                        "quantity=%d, " +
                        "hasStock=%s" +
                        "]",
                this.id,
                this.getProductId(),
                this.getQuantity(),
                this.hasStock);
    }

}
