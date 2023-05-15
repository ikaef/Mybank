package com.example.mybank.infrastructure.database.client;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "CLIENT")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class ClientDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    @SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", allocationSize = 1)
    private int idClient;

    @Column(name = "prenom")
    private String prénom;

    private String nom;

}
