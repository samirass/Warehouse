package uz.pdp.stock.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.util.Set;
import java.util.UUID;

@Entity(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Id
    private UUID id;
    private String first_name;
    private String last_name;
    private String phone_number;
    private Integer password;
    private Boolean is_active = false;
    private String role;
    private String code;
    @ManyToMany
    private Set<WareHouse> wareHouseSet;


}
