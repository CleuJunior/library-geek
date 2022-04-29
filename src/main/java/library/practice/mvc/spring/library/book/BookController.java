package library.practice.mvc.spring.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController implements Serializable {
    private static final long serialVersionUID = 1L;

    List<Book> bookList = new ArrayList<>();
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) { this.bookService = bookService; }

    @GetMapping
    public List<Book> listOfBooks () {
        return bookService.findAllBooks();
    }

    @GetMapping(value = "/{id}")
    public Book getBookById (@PathVariable Long id) {
        return bookList.get(Math.toIntExact(id) -1);
    }

    @PostMapping("/add")
    public void  addNewBook (@RequestBody Book book) {
        bookList.add(book);
        System.out.println(book.toString());

    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable Long id) {
        bookList.remove(Math.toIntExact(id) -1);

    }


}
