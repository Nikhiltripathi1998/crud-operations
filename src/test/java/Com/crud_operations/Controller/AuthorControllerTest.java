package Com.crud_operations.Controller;


import Com.crud_operations.Persistence.Model.Author;
import Com.crud_operations.Persistence.Model.Repository.AuthorRepository;
import Com.crud_operations.delegate.AuthorController;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthorController.class)
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorRepository authorRepository;

    @MockBean
    private AuthorController controller;


    @Test
    public void testAddAuthor() throws Exception {
        Author author = new Author();
        author.setId(1l);
        author.setName("Nikhil");
        author.setBio("Author of many book");

        when(authorRepository.save(Mockito.any(Author.class))).thenReturn(author);

        String authorJson = """
            {
                "name": "Nikhil",
                "bio": "Author of many books"
            }
        """;

        mockMvc.perform(post("/api/authors")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(authorJson))
                .andExpect(status().isOk());
    }

}
