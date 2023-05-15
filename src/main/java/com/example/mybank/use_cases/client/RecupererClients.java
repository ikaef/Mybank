package com.example.mybank.use_cases.client;

import com.example.mybank.domain.entities.Client;
import com.example.mybank.infrastructure.database.client.ClientDatabase;
import com.example.mybank.use_cases.ports.ClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecupererClients {
    public final ClientPort clientPort;

    public List<Client> executer(){
        return clientPort.récupérerTousLesClients();

    }
}
