package uz.pdp.stock.repository;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.stock.entity.AttachmentContent;

public interface AttachmentContentRepository extends JpaRepository<AttachmentContent,Integer> {
}
