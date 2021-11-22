package uz.developer.appwerehouse.service;

import uz.developer.appwerehouse.payload.ClientDto;
import uz.developer.appwerehouse.payload.Result;

public interface ClientService {
    Result getOneClient(Integer id);

    Result getAllClient();

    Result deleteClient(Integer id);

    Result editClient(Integer id, ClientDto clientDto);

    Result addClient(ClientDto clientDto);
}
