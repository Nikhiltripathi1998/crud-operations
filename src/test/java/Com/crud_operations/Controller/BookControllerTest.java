package Com.crud_operations.Controller;


import Com.crud_operations.Persistence.Model.Repository.BookRepository;
import Com.crud_operations.delegate.BookController;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BookController.class)

public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookRepository bookRepository;

    @Test
    public void testGetAllBooks() throws Exception {
        when(bookRepository.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/Book"))
                .andExpect(status().isOk())
                .andExpect(content().json("[]"));
    }
}
