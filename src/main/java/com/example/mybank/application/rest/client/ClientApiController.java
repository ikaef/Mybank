package com.example.mybank.application.rest.client;

import com.example.mybank.domain.entities.Client;
import com.example.mybank.infrastructure.database.client.ClientDatabase;
import com.example.mybank.use_cases.client.RecupererClientParId;
import com.example.mybank.use_cases.client.RecupererClients;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/client")
public class ClientApiController {
    private RecupererClients récupérérClients;
    private RecupererClientParId récupérerClientParId;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List <Client> récupererTousLesClients() {
        return récupérérClients.executer();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Client récupérerClientParId(@PathVariable int id) {
        return récupérerClientParId.executer(id);
    }
}
