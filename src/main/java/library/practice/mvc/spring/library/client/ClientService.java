package library.practice.mvc.spring.library.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) { this.clientRepository = clientRepository; }

    @Transactional
    public List<ClientDTO> listOfClients() {
        List<Client> clientEntityList = clientRepository.findAll();
        return clientEntityList.stream()
                .map(ClientDTO::new)
                .collect(Collectors.toList());
    }
}
