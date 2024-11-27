package Com.crud_operations.delegate;


import Com.crud_operations.Persistence.Model.Author;
import Com.crud_operations.Persistence.Model.Book;
import Com.crud_operations.Persistence.Model.Repository.AuthorRepository;
import Com.crud_operations.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private LibraryService service;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @GetMapping("{id}/books")
    public List<Book> getBookByAuthor(@PathVariable Long id) {
        return  service.getBooksByAuthor(id);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@RequestBody Author author) {

        Author saveAuthor = authorRepository.save(author);
        return ResponseEntity.status(201).body(saveAuthor);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Long id, @RequestBody Author author) {
        author.setId(id);
        return authorRepository.save(author);
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable Long id) {
        authorRepository.deleteById(id);
    }

}
