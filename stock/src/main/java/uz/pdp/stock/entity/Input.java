package uz.pdp.stock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Input {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private Integer id;
    private Object data;
    private String code;
    private Integer facture_Number;
    @ManyToOne
    private Currency currency;
    @ManyToOne
    private Supplier supplier;
    @ManyToOne
    private WareHouse wareHouse;
}
