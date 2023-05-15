package com.example.mybank.use_cases.comptes;

import com.example.mybank.domain.entities.Compte;
import com.example.mybank.use_cases.ports.ComptePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RecupererCompteParId {

    private final ComptePort comptePort;
    public Compte exécuter(int numéroCompte) {

        return comptePort.récupérerCompteParId(numéroCompte);

    }
}
