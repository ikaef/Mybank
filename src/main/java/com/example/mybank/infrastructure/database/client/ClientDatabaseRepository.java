package com.example.mybank.infrastructure.database.client;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientDatabaseRepository extends JpaRepository<ClientDatabase, Integer> {
    Optional<ClientDatabase> findByIdClient(int id);
}
