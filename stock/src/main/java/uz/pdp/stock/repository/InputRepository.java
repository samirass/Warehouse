package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Input;

public interface InputRepository extends JpaRepository<Input,Integer> {
    boolean existsByCode(String code);
}
