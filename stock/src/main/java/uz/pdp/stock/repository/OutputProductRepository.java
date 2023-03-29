package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.OutputProduct;

public interface OutputProductRepository extends JpaRepository<OutputProduct,Integer> {
}
