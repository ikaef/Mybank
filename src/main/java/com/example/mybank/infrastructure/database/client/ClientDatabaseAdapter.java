package com.example.mybank.infrastructure.database.client;

import com.example.mybank.domain.entities.Client;
import com.example.mybank.domain.exceptions.ClientIntrouvableException;
import com.example.mybank.domain.mappers.ClientDatabaseMapper;
import com.example.mybank.use_cases.ports.ClientPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@AllArgsConstructor
public class ClientDatabaseAdapter implements ClientPort {
    private final ClientDatabaseRepository clientDatabaseRepository;

    @Override
    public Client récupérerClientParId(int idClient) {
        var clientRetourné =  clientDatabaseRepository.findByIdClient(idClient);
        if (clientRetourné.isEmpty())
            throw new ClientIntrouvableException(idClient);
        return ClientDatabaseMapper.toClient(clientRetourné.get());
    }

    @Override
    public List<Client> récupérerTousLesClients() {

        return ClientDatabaseMapper.toClients(clientDatabaseRepository.findAll());
    }


}
