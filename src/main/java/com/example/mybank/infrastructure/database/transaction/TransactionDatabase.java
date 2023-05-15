package com.example.mybank.infrastructure.database.transaction;

import com.example.mybank.domain.enums.Operation;
import com.example.mybank.infrastructure.database.compte.CompteDatabase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TRANSACTION")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class TransactionDatabase {

    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Id
    private UUID idTransaction;

    @Enumerated(value = EnumType.STRING)
    private Operation operation;

    @OneToOne
    @JoinColumn(name = "numero_compte")
    private CompteDatabase compte;

    private BigDecimal montant;
}
