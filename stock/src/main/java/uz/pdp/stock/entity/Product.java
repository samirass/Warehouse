package uz.pdp.stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Id
    private UUID id ;
    private String name;
    @ManyToOne
    private Category category;
    @OneToOne
    private Attachment photo;
    private String code;
    private Boolean is_active = false;
    private Integer expire_date;
    @ManyToOne
    private Measurement measurement;

}
