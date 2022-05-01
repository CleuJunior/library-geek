package library.practice.mvc.spring.library.book;


import com.sun.istack.NotNull;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@Entity(name = "tb_book")
@Table(name = "tb_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "id")
    private UUID id;

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
