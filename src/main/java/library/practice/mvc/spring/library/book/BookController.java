package library.practice.mvc.spring.library.book;

import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController implements Serializable {
    private static final long serialVersionUID = 1L;

    @GetMapping
    public List<Book> listOfBooks () {

        return List.of(
                new Book(1l, "Harry Potter e a Pedra Filosofal", "J. K. Rowling", 264, 12.24d),
                new Book(2l, "Harry Potter e a Câmara Secreta", "J. K. Rowling", 287, 15.21d),
                new Book(3l, "Harry Potter e o Prisioneiro de Azkaban", "J. K. Rowling", 288, 13.56d)
        );
    }

    @GetMapping(value = "/{id}")
    public Book getBookById (@PathVariable String id) {
        if(id.equals("1")) return new Book(1l, "Harry Potter e a Pedra Filosofal", "J. K. Rowling", 264, 12.24d);
        if(id.equals("2")) return new Book(2l, "Harry Potter e a Câmara Secreta", "J. K. Rowling", 287, 15.21d);
        if(id.equals("3")) return new Book(3l, "Harry Potter e o Prisioneiro de Azkaban", "J. K. Rowling", 288, 13.56d);

        return null;
    }

    @PostMapping()
    public void  addNewBook (Long id, String title, String author, int totalPages, double rent) {
        Book book = new Book(id, title, author, totalPages, rent);

        System.out.println(book.toString());

    }

}
