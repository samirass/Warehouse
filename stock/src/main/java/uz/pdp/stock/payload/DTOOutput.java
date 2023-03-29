package uz.pdp.stock.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOOutput {
    private Object data;
    private Integer warehouse_id;
    private Integer supplier_id;
    private Integer currency_id;
    private String code;
    private Integer facture_Number;
}
