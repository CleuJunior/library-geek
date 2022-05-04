package library.practice.mvc.spring.library.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) { this.bookRepository = bookRepository; }

    @Transactional(readOnly = true)
    public List<BookDTO> findAllBooks() {
        List<Book> books = bookRepository.findAll();

        return  books.stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public BookDTO findBookById(UUID id) {
        Optional<Book> bookObject = bookRepository.getBookByUUID(id);
        Book entityBook = bookObject.orElseThrow(RuntimeException::new);

        return new BookDTO(entityBook);
    }

    @Transactional(readOnly = true)
    public BookDTO finBookByTitle(String title) {
        Optional<Book> bookObject = bookRepository.getBookByTitle(title);
        Book entityBook = bookObject.orElseThrow(RuntimeException::new);

        return new BookDTO(entityBook);
    }

    @Transactional(readOnly = true)
    public BookDTO saveBook(BookDTO bookDTO) {
        Book bookEntity = new Book();
        bookEntity.setTitle(bookDTO.getTitle());
        bookEntity.setAuthor(bookDTO.getAuthor());
        bookEntity.setTotalPages(bookDTO.getTotalPages());
        bookEntity.setPrice(bookDTO.getPrice());

        bookRepository.saveAndFlush(bookEntity);

        return new BookDTO(bookEntity);
    }

    @Transactional
    public BookDTO updateBook(UUID id, BookDTO bookDTO) {
        Optional<Book> bookObject = bookRepository.getBookByUUID(id);
        Book entityBook = bookObject.orElseThrow(RuntimeException::new);

        entityBook.setTitle(bookDTO.getTitle());
        entityBook.setAuthor(bookDTO.getAuthor());
        entityBook.setTotalPages(bookDTO.getTotalPages());
        entityBook.setPrice(bookDTO.getPrice());

        return new BookDTO(entityBook);
    }

    public void deleteBookByUUID(UUID id) {

        bookRepository.deleteBookByUUID(id);
    }
}
