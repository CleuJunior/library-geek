package library.practice.mvc.spring.library.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) { this.clientRepository = clientRepository; }

    @Transactional(readOnly = true)
    public List<ClientDTO> listOfClients() {
        List<Client> clientEntityList = clientRepository.findAll();
        return clientEntityList.stream()
                .map(ClientDTO::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ClientDTO findClientById(Long id) {
        Optional<Client> clientObject = clientRepository.findById(id);
        Client entityClient = clientObject.orElseThrow(RuntimeException::new);

        return new ClientDTO(entityClient);

    }

    @Transactional(readOnly = true)
    public ClientDTO saveClient(ClientDTO clientDTO) {
        Client clientEntity = new Client();

        clientEntity.setName(clientDTO.getName());
        clientEntity.setSecurityNumber(clientDTO.getSecurityNumber());
        clientEntity.setBirthDate(clientDTO.getBirthDate());
        clientEntity.setAddress(clientDTO.getAddress());
        clientEntity.setPhoneNumber(clientDTO.getPhoneNumber());

        clientRepository.save(clientEntity);

        return new ClientDTO(clientEntity);
    }

    @Transactional
    public ClientDTO updateClient(Long id, ClientDTO clientDTO) {
        Client clientEntity = clientRepository.findById(id)
                .orElseThrow();

        clientEntity.setName(clientDTO.getName());
        clientEntity.setSecurityNumber(clientDTO.getSecurityNumber());
        clientEntity.setBirthDate(clientDTO.getBirthDate());
        clientEntity.setAddress(clientEntity.getAddress());
        clientEntity.setPhoneNumber(clientDTO.getPhoneNumber());

        return new ClientDTO(clientEntity);
    }


    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
