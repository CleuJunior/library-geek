package library.practice.mvc.spring.library.client;

import library.practice.mvc.spring.library.book.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

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
    public ResponseEntity<ClientDTO> clientList(@PathVariable Long id) {
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
    public ResponseEntity<ClientDTO> addNewClient(@PathVariable Long id, @RequestBody ClientDTO clientDTO) {
        clientDTO = clientService.updateClient(id, clientDTO);
        return ResponseEntity.ok().body(clientDTO);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Client> delete(@PathVariable Long id) {
        clientService.deleteClientById(id);
        return ResponseEntity.noContent().build();

    }


}
