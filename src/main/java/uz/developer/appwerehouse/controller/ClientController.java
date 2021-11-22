package uz.developer.appwerehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developer.appwerehouse.payload.ClientDto;
import uz.developer.appwerehouse.payload.Result;
import uz.developer.appwerehouse.service.ClientService;

@RestController
@RequestMapping("/client")
public class ClientController {
    @Autowired
    ClientService clientService;

    @GetMapping
    public Result getAllClient() {
        return clientService.getAllClient();
    }

    @GetMapping("/id")
    public Result getClient(@PathVariable Integer id) {
        return clientService.getOneClient(id);
    }

    @PostMapping
    public Result addClient(@RequestBody ClientDto clientDto) {
        return clientService.addClient(clientDto);
    }

    @DeleteMapping("/id")
    public Result deleteClient(@PathVariable Integer id) {
        return clientService.deleteClient(id);
    }

    @PutMapping("/id")
    public Result editClient(@PathVariable Integer id, @RequestBody ClientDto clientDto) {
        return clientService.editClient(id, clientDto);
    }
}
