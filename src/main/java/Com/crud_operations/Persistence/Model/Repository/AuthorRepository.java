package Com.crud_operations.Persistence.Model.Repository;

import Com.crud_operations.Persistence.Model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
