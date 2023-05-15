package com.example.mybank.infrastructure.database.compte;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CompteRepository extends JpaRepository<CompteDatabase, Integer> {

    Optional<CompteDatabase> getComptesByNuméroCompte(int numéroCompte);
    List<CompteDatabase> getComptesByClient_IdClient(int idClient);
}
