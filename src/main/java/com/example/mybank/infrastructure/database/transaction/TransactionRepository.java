package com.example.mybank.infrastructure.database.transaction;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TransactionRepository extends JpaRepository<TransactionDatabase, Integer> {
    Optional<TransactionDatabase> findByIdTransaction(UUID idTransaction);

    List<TransactionDatabase> findAllByCompte_NuméroCompte(int numéroCompte);

}
