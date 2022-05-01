package library.practice.mvc.spring.library.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

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

    public Client(String name, String securityNumber, LocalDate birthDate, String address, String phoneNumber) {
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
