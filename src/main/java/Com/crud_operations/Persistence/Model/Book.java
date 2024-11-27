package Com.crud_operations.Persistence.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private LocalDate publishedDate;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private Author author;
}
