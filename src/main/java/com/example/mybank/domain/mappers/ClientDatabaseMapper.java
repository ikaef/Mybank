package com.example.mybank.domain.mappers;

import com.example.mybank.domain.entities.Client;
import com.example.mybank.infrastructure.database.client.ClientDatabase;

import java.util.List;

public class ClientDatabaseMapper {

    public static Client toClient(ClientDatabase clientDatabase) {
        return Client.builder()
                .idClient(clientDatabase.getIdClient())
                .prenom(clientDatabase.getPrénom())
                .nom(clientDatabase.getNom())
                .build();
    }

    public static List<Client> toClients(List<ClientDatabase> clientsDatabase) {
        return clientsDatabase.stream().map(ClientDatabaseMapper::toClient).toList();
    }

    public static ClientDatabase toClientDatabase(Client client) {
        return ClientDatabase.builder()
                .idClient(client.getIdClient())
                .prénom(client.getPrenom())
                .nom(client.getNom())
                .build();
    }
}

