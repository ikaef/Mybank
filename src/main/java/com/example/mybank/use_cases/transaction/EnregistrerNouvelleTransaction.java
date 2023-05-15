package com.example.mybank.use_cases.transaction;

import com.example.mybank.application.rest.transaction.TransactionApi;
import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.domain.enums.Operation;
import com.example.mybank.domain.mappers.TransactionDatabaseMapper;
import com.example.mybank.use_cases.ports.ClientPort;
import com.example.mybank.use_cases.ports.ComptePort;
import com.example.mybank.use_cases.ports.TransactionPort;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class EnregistrerNouvelleTransaction {
    private final TransactionPort transactionPort;
    private final ClientPort clientPort;
    private final ComptePort comptePort;

    @Transactional
    public void exécuter(TransactionApi transactionApi) {

        var compte = comptePort.récupérerCompteParId(transactionApi.getNuméroCompte());
        var opération = Operation.of(transactionApi.getOpération().toUpperCase());
        var transaction =
                Transaction.builder()
                        .operation(opération)
                        .compte(compte)
                        .montant(transactionApi.getMontant())
                        .build();
        if (opération.estUnDepot())
            compte.setSolde(compte.getSolde().add(transaction.getMontant()));
        else
            compte.setSolde(compte.getSolde().subtract(transaction.getMontant()));
        comptePort.majCompte(compte);
        var transactionDatabase = TransactionDatabaseMapper.toTransactionDatabase(transaction);
        transactionPort.enregistrerNouvelleTransaction(transactionDatabase);

    }
}
