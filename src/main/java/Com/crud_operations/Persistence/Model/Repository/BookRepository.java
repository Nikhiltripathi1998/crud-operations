package Com.crud_operations.Persistence.Model.Repository;

import Com.crud_operations.Persistence.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByAuthorId(Long authorId);
}
