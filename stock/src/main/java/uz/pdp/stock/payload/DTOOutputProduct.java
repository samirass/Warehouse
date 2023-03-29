package uz.pdp.stock.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOOutputProduct {
    private Integer product_id;
    private Double count;
    private Double price;
    private Integer expireData;
    private Integer outputId;
}
