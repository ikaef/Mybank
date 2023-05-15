package com.example.mybank.domain.mappers;

import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.infrastructure.database.transaction.TransactionDatabase;

import java.util.List;

public class TransactionDatabaseMapper {
    public static TransactionDatabase toTransactionDatabase(Transaction transaction){
        return TransactionDatabase.builder()
                .idTransaction(transaction.getIdTransaction())
                .operation(transaction.getOperation())
                .montant(transaction.getMontant())
                .compte(CompteDatabaseMapper.toCompteDatabase(transaction.getCompte()))
                .build();
    }
    public static Transaction toTransaction(TransactionDatabase transactionDatabase){
        return Transaction.builder()
                .idTransaction(transactionDatabase.getIdTransaction())
                .operation(transactionDatabase.getOperation())
                .montant(transactionDatabase.getMontant())
                .compte(CompteDatabaseMapper.toCompte(transactionDatabase.getCompte()))
                .build();
    }
    public static List<Transaction> toTransactions(List<TransactionDatabase> transactionsDatabase){
        return transactionsDatabase.stream().map(TransactionDatabaseMapper::toTransaction).toList();
    }

    }
