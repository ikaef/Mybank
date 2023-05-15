package com.example.mybank.use_cases.comptes;

import com.example.mybank.domain.entities.Compte;
import com.example.mybank.use_cases.client.RecupererClientParId;
import com.example.mybank.use_cases.ports.ComptePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RecupererLesComptesDUnClient {

    private final ComptePort comptePort;
    private final RecupererClientParId récupérerClientParId;
    public List<Compte> exécuter(int idClient){
        vérifierExistanceClient(idClient);
        return comptePort.récupérérLesComptesDUnClient(idClient);
    }

    private void vérifierExistanceClient(int idClient){
        récupérerClientParId.executer(idClient);
    }

}
