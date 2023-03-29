package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Measurement;

import java.util.List;
import java.util.Optional;

public interface MeasurementRepository extends JpaRepository<Measurement,Integer> {
    boolean existsByName(String name);
    List<Measurement> findAllByIs_activeIsTrue();
    Optional<Measurement> findByIs_activeIsTrue(Integer id);
}
