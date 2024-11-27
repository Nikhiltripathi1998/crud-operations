package Com.crud_operations.service;

import Com.crud_operations.Persistence.Model.Author;
import Com.crud_operations.Persistence.Model.Book;
import Com.crud_operations.Persistence.Model.Repository.AuthorRepository;
import Com.crud_operations.Persistence.Model.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getBooksByAuthor(Long authorId) {
        return bookRepository.findByAuthorId(authorId);
    }

}