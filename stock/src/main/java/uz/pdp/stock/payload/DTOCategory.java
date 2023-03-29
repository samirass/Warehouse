package uz.pdp.stock.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DTOCategory {
    private String name;
    private Integer category_id;
}
//DTO объект - объект, который не содержит методы.
// Он может содержать только поля, геттеры/сеттеры, и конструкторы.
//Data Transfer Object - объект, передающий данные.
// Данные - это и есть поля в классе.