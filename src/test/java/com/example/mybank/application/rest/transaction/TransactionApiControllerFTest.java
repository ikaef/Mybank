package com.example.mybank.application.rest.transaction;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class TransactionApiControllerFTest {
    /* ICI J'AI FAIS LE CHOIX DE JOUER LES TESTS SUR LA BASE DE PROD(C'est pas propre) Surtout que les données peuvent
    changer, PARCEQUE JE N'AI PAS EU LE TEMPS DE CONFIGURER UNE BASE DE DONNEES POUR LES TESTS*/
    @Autowired
    private MockMvc mockMvc;
    String newIdTransactionValide = "1124d9e8-6266-4bcf-8035-37a02ba75c69";


    @Test
    void doitRécupérérTransactionParId() throws Exception {
        var idTransactionValide = "1124d9e8-6266-4bcf-8035-37a02ba75c69";
        mockMvc.perform(get("http://localhost:8080/transactions/{idTransaction}", idTransactionValide))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idTransaction").value("1124d9e8-6266-4bcf-8035-37a02ba75c69"))
                .andExpect(jsonPath("$.operation").value("RETRAIT"))
                .andExpect(jsonPath("$.compte.numeroCompte").value(1))
                .andExpect(jsonPath("$.compte.client.idClient").value(1))
                .andExpect(jsonPath("$.compte.client.prenom").value("Ibrahima"))
                .andExpect(jsonPath("$.compte.client.nom").value("FALL"))
                .andExpect(jsonPath("$.compte.solde").value(3800.0))
                .andExpect(jsonPath("$.montant").value("250.0"));
    }

    @Test
    void doitRetournerExceptionSiIdTransactionInexistant() throws Exception {
        var idTransactionInvalide = "1124d9e8-6266-4bcf-8035-37a02ba75c6a";
        mockMvc.perform(get("http://localhost:8080/transactions/{idTransaction}", idTransactionInvalide))
                .andExpect(status().isNotFound());
    }

    @Test
    void doitRécupérérTransactionParNuméroCompte() throws Exception {
        var numéroCompteValide = 1;
        mockMvc.perform(get("http://localhost:8080/comptes/{numeroCompte}/transactions", numéroCompteValide))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idTransaction").value("1124d9e8-6266-4bcf-8035-37a02ba75c69"))
                .andExpect(jsonPath("$[0].operation").value("RETRAIT"))
                .andExpect(jsonPath("$[0].compte.numeroCompte").value(1))
                .andExpect(jsonPath("$[0].compte.client.idClient").value(1))
                .andExpect(jsonPath("$[0].compte.client.prenom").value("Ibrahima"))
                .andExpect(jsonPath("$[0].compte.client.nom").value("FALL"))
                .andExpect(jsonPath("$[0].compte.solde").value(3800.0))
                .andExpect(jsonPath("$[0].montant").value("250.0"));
    }

    @Test
    void doitRetournerExceptionSiNuméroCompteInexistant() throws Exception {
        var numéroCompteInexistant = 3546;
        mockMvc.perform(get("http://localhost:8080/compte/{numeroCompte}/transactions", numéroCompteInexistant))
                .andExpect(status().isNotFound());

    }

    @Test
    void doitRécupérérTransactionParIdClient() throws Exception {
        var idClientValide = 1;
        mockMvc.perform(get("http://localhost:8080/clients/{idClient}/transactions", idClientValide))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].idTransaction").value("1124d9e8-6266-4bcf-8035-37a02ba75c69"))
                .andExpect(jsonPath("$[0].operation").value("RETRAIT"))
                .andExpect(jsonPath("$[0].compte.numeroCompte").value(1))
                .andExpect(jsonPath("$[0].compte.client.idClient").value(1))
                .andExpect(jsonPath("$[0].compte.client.prenom").value("Ibrahima"))
                .andExpect(jsonPath("$[0].compte.client.nom").value("FALL"))
                .andExpect(jsonPath("$[0].compte.solde").value(3800.0))
                .andExpect(jsonPath("$[0].montant").value("250.0"));
    }

    @Test
    void doitRetournerExceptionSiIdClientInexistant() throws Exception {
        var idClientInexistant = 3534;
        mockMvc.perform(get("http://localhost:8080/clients/{idClient}/transactions", idClientInexistant))
                .andExpect(status().isNotFound());
    }

    @Test
    void doitEnregistrerNouvelleTransaction() throws Exception {
        var transaction =
                TransactionApi.builder()
                        .opération("DEPOT")
                        .montant(new BigDecimal("400"))
                        .numéroCompte(7)
                        .build();
        var objectMapper = new ObjectMapper();

        mockMvc.perform(post("http://localhost:8080/transaction/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transaction)))
                .andExpect(status().isOk());
    }


    @Test
    void doitRetournerExceptionSiOperationMalSaisie() throws Exception {
        var transaction =
                TransactionApi.builder()
                        .opération("DEPT")
                        .montant(new BigDecimal("400"))
                        .numéroCompte(7)
                        .build();
        var objectMapper = new ObjectMapper();

        mockMvc.perform(post("http://localhost:8080/transaction/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transaction)))
                .andExpect(status().isBadRequest());
    }
    @Test
    void doitRetournerExceptionSiMontantMalSaisie() throws Exception {
        var transaction =
                TransactionApi.builder()
                        .opération("DEPT")
                        .montant(new BigDecimal("-34"))
                        .numéroCompte(7)
                        .build();
        var objectMapper = new ObjectMapper();

        mockMvc.perform(post("http://localhost:8080/transaction/new")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(transaction)))
                .andExpect(status().isBadRequest());
    }
}
