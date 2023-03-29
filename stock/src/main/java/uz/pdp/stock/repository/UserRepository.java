package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByPhone_number(String phone_number);
     List<User> findAllByIs_activeIsTrue();
     Optional<User> findByIdIs_activeIsTrue(Integer id);
}
