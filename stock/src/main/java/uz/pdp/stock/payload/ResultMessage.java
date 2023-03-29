package uz.pdp.stock.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMessage {
    private String message;
    private boolean success;
   // private Object data; /// Object - Берет все переменные
}
