package library.practice.mvc.spring.library.client;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
@DynamicInsert
@Table(name = "tb_client")
@Entity(name = "tb_client")
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;


    private String name;

    private String securityNumber;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDate birthDate;


    private String address;

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
