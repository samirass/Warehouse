package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Output;

public interface OutputRepository extends JpaRepository<Output,Integer> {
    boolean existsByCode(String code);


}
