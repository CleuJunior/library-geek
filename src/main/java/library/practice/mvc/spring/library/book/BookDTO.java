package library.practice.mvc.spring.library.book;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class BookDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String author;
    private Integer totalPages;
    private double price;

    private String dateOfArrival;

    public BookDTO(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.totalPages = book.getTotalPages();
        this.price = book.getPrice();
        this.dateOfArrival = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
                .format(book.getTimeStamp());

    }
}
