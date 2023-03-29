package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    boolean existsByNameAndCategory_id(String name,Integer category_id);
    List<Category> findAllByIs_activeIsTrue();
    Optional<Category> findByIdAndAndIs_activeTrue (Integer id);

}
