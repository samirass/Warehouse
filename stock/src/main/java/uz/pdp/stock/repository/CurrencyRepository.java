package uz.pdp.stock.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Currency;

import java.util.List;
import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency,Integer> {
    boolean existsByName(String name);
    List<Currency> findAllByIs_activeIsTrue();
    Optional<Currency> findByIs_activeIsTrue(Integer id);
}
