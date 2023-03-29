package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Supplier;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SupplierRepository extends JpaRepository<Supplier, UUID> {
    boolean existsByPhone_number(String phone_number);
    List<Supplier> findAllByIs_activeIsTrue();
    Optional<Supplier> findByIs_activeIsTrue(Integer id);
}
