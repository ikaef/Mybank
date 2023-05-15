package com.example.mybank.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Client {
    private int idClient;
    private String prenom;
    private String nom;
}
