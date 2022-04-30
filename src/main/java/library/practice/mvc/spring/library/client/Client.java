package library.practice.mvc.spring.library.client;

import library.practice.mvc.spring.library.book.Book;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String securityNumber;
    @Getter
    @Setter
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate birthDate;

    @Getter
    @Setter
    private String address;
    @Getter
    @Setter
    private String phoneNumber;

//    @Getter
//    private final List<Book> purchasedBooks = new ArrayList<>();

    public Client(Long id, String name, String securityNumber, LocalDate birthDate, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.securityNumber = securityNumber;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

//    public void setPurchaseBooks(Book book) {
//        purchasedBooks.add(book);
//    }
}
