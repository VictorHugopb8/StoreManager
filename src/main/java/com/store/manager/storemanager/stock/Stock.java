package com.store.manager.storemanager.stock;

import com.store.manager.storemanager.product.Product;
import lombok.*;

import javax.persistence.*;

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

    @OneToOne
    private Product product;

    private Long quantity;
    private Boolean hasStock;

    @Override
    public String toString() {
        return String.format(
                "Stock[" +
                        "id=%d, " +
                        "product=%s, " +
                        "quantity=%d, " +
                        "hasStock=%s" +
                        "]",
                this.id,
                this.getProduct().getName(),
                this.getQuantity(),
                this.hasStock);
    }

}
