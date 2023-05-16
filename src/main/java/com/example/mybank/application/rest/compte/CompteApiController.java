package com.example.mybank.application.rest.compte;

import com.example.mybank.domain.entities.Compte;
import com.example.mybank.use_cases.comptes.RecupererCompteParId;
import com.example.mybank.use_cases.comptes.RecupererLesComptesDUnClient;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CompteApiController {
    private final RecupererLesComptesDUnClient récupérerLesComptesDUnClient;
    private final RecupererCompteParId récupérerCompteParId;

    @GetMapping(value = "comptes/{numéroCompte}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Compte récupérérCompte(@PathVariable int numéroCompte) {
        return récupérerCompteParId.exécuter(numéroCompte);
    }

    @GetMapping(value = "clients/{idClient}/comptes", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public List<Compte> récupérérComptesDUnClient(@PathVariable int idClient) {

        return récupérerLesComptesDUnClient.exécuter(idClient);
    }
}
