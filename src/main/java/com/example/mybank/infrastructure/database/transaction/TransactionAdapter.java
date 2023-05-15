package com.example.mybank.infrastructure.database.transaction;

import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.domain.exceptions.TransactionInexistanteException;
import com.example.mybank.domain.mappers.TransactionDatabaseMapper;
import com.example.mybank.use_cases.ports.TransactionPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@AllArgsConstructor
public class TransactionAdapter implements TransactionPort {

    private final TransactionRepository transactionRepository;

    @Override
    public Transaction récupérerTransactionParId(UUID idTransaction) {
        var transactionRetourné = transactionRepository.findByIdTransaction(idTransaction);
        if (transactionRetourné.isEmpty())
            throw new TransactionInexistanteException(idTransaction);

        return TransactionDatabaseMapper.toTransaction(transactionRetourné.get());
    }

    @Override
    public List<Transaction> récupérerTransactionParCompte(int numéroCompte) {
        return TransactionDatabaseMapper.toTransactions(
                transactionRepository.findAllByCompte_NuméroCompte(numéroCompte));
    }

    @Override
    public void enregistrerNouvelleTransaction(TransactionDatabase transactionDatabase) {
        transactionRepository.save(transactionDatabase);
    }
}
