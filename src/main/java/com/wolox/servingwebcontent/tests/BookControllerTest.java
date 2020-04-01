package com.wolox.servingwebcontent.tests;






import com.wolox.servingwebcontent.models.Book;
import com.wolox.servingwebcontent.packages.BookRepository;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@WebMvcTest(BookControllerTest.class)
public class BookControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookRepository bookRepository;


    @Test
    public void givenBooks_whenGetBooks_thenReturnJsonArray()
        throws Exception {

        Book book = new Book("genre", "author","image", "Title",
            "subtitle", "publisher",1994, 100,
            "435342342342");

        List<Book> allBooks = Arrays.asList(book);

       


        mvc.perform(MockMvcRequestBuilders.get("/api/books")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());


    }

}
