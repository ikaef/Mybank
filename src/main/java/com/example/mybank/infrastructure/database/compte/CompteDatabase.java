package com.example.mybank.infrastructure.database.compte;

import com.example.mybank.infrastructure.database.client.ClientDatabase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "COMPTE")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class CompteDatabase {

    @Column(name = "numero_compte")
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_sequence")
    @SequenceGenerator(name = "my_sequence", sequenceName = "my_sequence", allocationSize = 1)
    private int numéroCompte;

    @ManyToOne
    @JoinColumn(name = "idClient")
    private ClientDatabase client;

    private BigDecimal solde;


}
