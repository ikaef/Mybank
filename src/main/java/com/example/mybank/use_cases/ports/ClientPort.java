package com.example.mybank.use_cases.ports;

import com.example.mybank.domain.entities.Client;
import com.example.mybank.infrastructure.database.client.ClientDatabase;

import java.util.List;

public interface ClientPort {
    Client récupérerClientParId(int id);
    List<Client> récupérerTousLesClients();
}
