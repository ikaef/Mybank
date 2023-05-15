package com.example.mybank.domain.mappers;

import com.example.mybank.domain.entities.Compte;
import com.example.mybank.infrastructure.database.compte.CompteDatabase;

import java.util.List;

public class CompteDatabaseMapper {
    public static Compte toCompte(CompteDatabase compteDatabase) {
        return Compte.builder()
                .numeroCompte(compteDatabase.getNuméroCompte())
                .client(ClientDatabaseMapper.toClient(compteDatabase.getClient()))
                .solde(compteDatabase.getSolde())
                .build();
    }

    public static List<Compte> toComptes(List<CompteDatabase> comptesDatabase) {
        return comptesDatabase.stream().map(CompteDatabaseMapper::toCompte).toList();
    }

    public static CompteDatabase toCompteDatabase(Compte compte) {
        return CompteDatabase.builder()
                .numéroCompte(compte.getNumeroCompte())
                .client(ClientDatabaseMapper.toClientDatabase(compte.getClient()))
                .solde(compte.getSolde())
                .build();
    }
}
