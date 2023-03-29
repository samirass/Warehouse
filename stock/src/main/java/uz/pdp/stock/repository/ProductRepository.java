package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Product;
import uz.pdp.stock.entity.Supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsByNameAndCategoryId(String name, Integer category_id);
    List<Product> findAllByIs_activeIsTrue();
    Optional<Product> findByIdAndIs_activeIsTrue(Integer id);


    Optional<Product> findById(Integer id);
}

