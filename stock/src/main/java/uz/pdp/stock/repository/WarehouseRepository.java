package uz.pdp.stock.repository;

import jakarta.persistence.metamodel.SingularAttribute;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.WareHouse;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface WarehouseRepository extends JpaRepository<WareHouse,Integer> {
   boolean existsByName(String name);

    List<WareHouse> findAllByIs_activeIsTrue();
    Optional<WareHouse> findByIdAndActiveIsTrue(Integer id);
    Optional<WareHouse> findByIdAndActiveIsTrue(SingularAttribute<AbstractPersistable, Serializable> id);
}
