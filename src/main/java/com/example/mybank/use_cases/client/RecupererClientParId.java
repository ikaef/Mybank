package com.example.mybank.use_cases.client;

import com.example.mybank.domain.entities.Client;
import com.example.mybank.infrastructure.database.client.ClientDatabase;
import com.example.mybank.use_cases.ports.ClientPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecupererClientParId {

    private final ClientPort clientPort;
    public Client executer(int idClient){
        return clientPort.récupérerClientParId(idClient);
    }

}
