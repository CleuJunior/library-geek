package library.practice.mvc.spring.library.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController implements Serializable {
    private static final long serialVersionUID = 1L;

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) { this.clientService = clientService; }

    @GetMapping
    public ResponseEntity<List<ClientDTO>> clientList() {
        return ResponseEntity.ok()
                .body(clientService.listOfClients());

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ClientDTO> clientList(@PathVariable UUID id) {
        return ResponseEntity.ok()
                .body(clientService.findClientById(id));

    }

    @PostMapping("/add")
    public ResponseEntity<ClientDTO> addNewClient(@RequestBody ClientDTO clientDTO) {
        clientDTO = clientService.saveClient(clientDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(clientDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(clientDTO);

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ClientDTO> addNewClient(@PathVariable UUID id, @RequestBody ClientDTO clientDTO) {
        clientDTO = clientService.updateClient(id, clientDTO);
        return ResponseEntity.ok().body(clientDTO);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Client> delete(@PathVariable UUID id) {
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();

    }


}
