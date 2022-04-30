package library.practice.mvc.spring.library.book;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "tb_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private  String title;
    private  String author;
    private Integer totalPages;
    private  double price;
    private LocalDateTime timeStamp;

    public Book(String title, String author, Integer totalPages, double price) {
        this.title = title;
        this.author = author;
        this.totalPages = totalPages;
        this.price = price;
        this.timeStamp = LocalDateTime.now();

    }

    public Book() { this.timeStamp = LocalDateTime.now(); }

}
