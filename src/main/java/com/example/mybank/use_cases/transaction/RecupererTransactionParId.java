package com.example.mybank.use_cases.transaction;

import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.infrastructure.database.transaction.TransactionDatabase;
import com.example.mybank.use_cases.ports.TransactionPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class RecupererTransactionParId {

    private final TransactionPort transactionPort;

    public Transaction executer(UUID idTransaction){
        return transactionPort.récupérerTransactionParId(idTransaction);
    }

}
