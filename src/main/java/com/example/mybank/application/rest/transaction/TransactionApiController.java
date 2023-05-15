package com.example.mybank.application.rest.transaction;

import com.example.mybank.domain.entities.Transaction;
import com.example.mybank.use_cases.transaction.EnregistrerNouvelleTransaction;
import com.example.mybank.use_cases.transaction.RecupererTransactionParCompte;
import com.example.mybank.use_cases.transaction.RecupererTransactionParId;
import com.example.mybank.use_cases.transaction.RecupererTransactionsParClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/transaction")
public class TransactionApiController {

    private final RecupererTransactionParId récupérerTransactionParId;
    private final RecupererTransactionParCompte récupérerTransactionParCompte;
    private final RecupererTransactionsParClient récupérerTransactionsParClient;
    private final EnregistrerNouvelleTransaction enregistrerNouvelleTransaction;

    @GetMapping(value = "/{idTransaction}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Transaction récupérérTransactionParId(@PathVariable UUID idTransaction) {
        return récupérerTransactionParId.executer(idTransaction);
    }

    @GetMapping(value = "/compte/{numéroCompte}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> récupérérTransactionParNuméroCompte(@PathVariable int numéroCompte) {
        return récupérerTransactionParCompte.exécuter(numéroCompte);
    }

    @GetMapping(value = "/client/{idClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Transaction> récupérérTransactionParIdClient(@PathVariable int idClient) {
        return récupérerTransactionsParClient.exécuter(idClient);
    }

    @PostMapping(value = "/new" , consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> enregistrerNouvelleTransaction(@RequestBody TransactionApi transactionApi){
        enregistrerNouvelleTransaction.exécuter(transactionApi);
        return ResponseEntity.ok("Transaction du compte "+
                transactionApi.getNuméroCompte()
                + " Validée !");
    }




}
