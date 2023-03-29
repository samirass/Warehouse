package uz.pdp.stock.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.Attachment;

import java.util.UUID;

public interface AttachmentRepository extends JpaRepository<Attachment, Integer> {
}
