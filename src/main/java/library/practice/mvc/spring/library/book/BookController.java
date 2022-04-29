package library.practice.mvc.spring.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/books")
public class BookController implements Serializable {
    private static final long serialVersionUID = 1L;
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) { this.bookService = bookService; }

    @GetMapping
    public ResponseEntity<List<BookDTO>> listOfBooks () {
        return ResponseEntity.ok().body(bookService.findAllBooks());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BookDTO> getBookById (@PathVariable Long id) {
        return ResponseEntity.ok().body(bookService.findBookById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addNewBook (@RequestBody BookDTO bookDTO) {
        bookDTO = bookService.saveBook(bookDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(bookDTO.getId()).toUri();
        return ResponseEntity.created(uri).body(bookDTO);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BookDTO> getBookById (@PathVariable Long id, @RequestBody BookDTO bookDTO) {
        BookDTO updateBook = bookService.updateBook(id, bookDTO);
        return ResponseEntity.ok().body(updateBook);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Book> delete(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();

    }


}
