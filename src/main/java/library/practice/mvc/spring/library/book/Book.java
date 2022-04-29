package library.practice.mvc.spring.library.book;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "tb_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String author;
    private Integer totalPages;
    private double rent;
    private LocalDateTime timeStamp;

    public Book(String title, String author, Integer totalPages, double rent) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.rent = rent;
        this.timeStamp = LocalDateTime.now();

    }

}
