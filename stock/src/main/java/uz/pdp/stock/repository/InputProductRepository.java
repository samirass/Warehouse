package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Input;
import uz.pdp.stock.entity.InputProduct;

public interface InputProductRepository extends JpaRepository<InputProduct,Integer> {
}
