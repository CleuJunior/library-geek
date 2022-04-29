package library.practice.mvc.spring.library.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController implements Serializable {
    private static final long serialVersionUID = 1L;

    @GetMapping
    public List<Client> clientList() {
        return List.of(
          new Client(1l, "Cleonildo", "9999909999", LocalDate.now(), "Rua foo number 0", "888888888"),
          new Client(1l, "Junior", "9999909999", LocalDate.now(), "Rua foo number 101", "99999999")


        );

    }

}
