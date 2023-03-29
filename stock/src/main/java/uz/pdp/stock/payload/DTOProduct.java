package uz.pdp.stock.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOProduct {
    private String name;
    private Integer categoryId;
    private Integer photoId;
    private Integer measurementId;

}
