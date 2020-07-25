package com.store.manager.storemanager.stock;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StockDTO {
    private Long id;
    private Long productId;
    private Long quantity;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Boolean hasStock;
}
