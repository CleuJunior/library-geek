package library.practice.mvc.spring.library.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) { this.clientService = clientService; }

    @GetMapping
    public List<ClientDTO> clientList() {
        return clientService.listOfClients();

    }

}
