package com.example.mybank.use_cases.ports;

import com.example.mybank.domain.entities.Compte;
import com.example.mybank.infrastructure.database.compte.CompteDatabase;

import java.util.List;

public interface ComptePort {

    Compte récupérerCompteParId(int numéroCompte);
    List<Compte> récupérérLesComptesDUnClient(int idClient);

    void majCompte(Compte compte);
}
