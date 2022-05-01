package library.practice.mvc.spring.library.client;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;

@NoArgsConstructor
public class ClientDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
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


    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.securityNumber = client.getSecurityNumber();
        this.birthDate = client.getBirthDate();
        this.address = client.getAddress();
        this.phoneNumber = client.getPhoneNumber();

    }

}
