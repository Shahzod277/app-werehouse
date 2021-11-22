package uz.developer.appwerehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developer.appwerehouse.entity.Client;
import uz.developer.appwerehouse.payload.ClientDto;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {
    @Autowired
    ClientRepository clientRepository;

    @Override
    public Result getOneClient(Integer id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            ClientDto clientDto = new ClientDto();
            clientDto.setName(optionalClient.get().getName());
            clientDto.setActive(optionalClient.get().getActive());
            clientDto.setPhoneNumber(optionalClient.get().getPhoneNumber());
            clientDto.setId(optionalClient.get().getId());
            return new Result("one cliend by id", 504, clientDto);
        }
        return new Result("id not found", 202, null);

    }

    @Override
    public Result getAllClient() {
        List<Client> allClient = clientRepository.findAll();
        if (allClient.isEmpty()) {
            return new Result("clients haven't", 203, null);
        }
        return new Result("all client", 409, allClient);
    }

    @Override
    public Result deleteClient(Integer id) {
        boolean byId = clientRepository.existsById(id);
        if (byId) {
            clientRepository.deleteById(id);
            return new Result("client deleted", 411);
        }
        return new Result("client id not found", 202, null);
    }

    @Override
    public Result editClient(Integer id, ClientDto clientDto) {
        Optional<ClientDto> optionalClientDto = clientRepository.findbyId(id);
        if (optionalClientDto.isPresent()) {
            Client client = new Client();
            client.setActive(clientDto.isActive());
            client.setName(clientDto.getName());
            boolean b = clientRepository.existsByPhoneNumberAndIdNot(clientDto.getPhoneNumber(), id);
            if (b) {
                return new Result("this phone number alrady added", 208, null);
            }
            client.setPhoneNumber(clientDto.getPhoneNumber());
            clientRepository.save(client);
            return new Result("client edit successfull", 402);
        }
        return new Result("client id not found", 303);

    }

    @Override
    public Result addClient(ClientDto clientDto) {
        boolean existsByName = clientRepository.existsByName(clientDto.getName());
        if (existsByName) {
            return new Result("client already added", 202);
        }
        Client client = new Client();
        client.setName(client.getName());
        client.setActive(client.getActive());
        boolean existsByPhoneNumber = clientRepository.existsByPhoneNumber(clientDto.getPhoneNumber());
        if (existsByPhoneNumber) {
            return new Result("this phone number had", 202, null);
        }
        client.setPhoneNumber(clientDto.getPhoneNumber());
        clientRepository.save(client);
        return new Result("successfull added", 405);
    }
}
