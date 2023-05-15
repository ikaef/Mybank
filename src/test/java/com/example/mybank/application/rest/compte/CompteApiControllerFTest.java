package com.example.mybank.application.rest.compte;

import jakarta.transaction.Transactional;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class CompteApiControllerFTest {
    /* ICI J'AI FAIS LE CHOIX DE JOUER LES TESTS SUR LA BASE DE PROD, PARCEQUE JE N'AI PAS EU LE TEMPS
    DE CONFIGURER UNE BASE DE DONNEES POUR LES TESTS*/

    @Autowired
    private MockMvc mockMvc;

    @Test
    void doitRécupérerCompteAvecNuméroCompte() throws Exception {
        var numéroCompte = 1;
        mockMvc.perform(get("http://localhost:8080/compte/{numéroCompte}", numéroCompte))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.numeroCompte").value(1))
                .andExpect(jsonPath("$.client.idClient").value(1))
                .andExpect(jsonPath("$.client.prenom").value("Ibrahima"))
                .andExpect(jsonPath("$.client.nom").value("FALL"))
                .andExpect(jsonPath("$.solde").value("3800.0"));
    }

    @Test
    void doitRetournerCompteInexistantException() throws Exception {
        var numéroCompteInexistant = 20;
        mockMvc.perform(get("http://localhost:8080/compte/{numéroCompte}", numéroCompteInexistant))
                .andExpect(status().isNotFound());
    }

    @Test
    void doitRécupérerTousLesComptesDunClientAvecLidClient() throws Exception {
        var idClient = 1;
        mockMvc.perform(get("http://localhost:8080/compte/client/{idClient}", idClient))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].numeroCompte").value(1))
                .andExpect(jsonPath("$[0].client.idClient").value(1))
                .andExpect(jsonPath("$[0].client.prenom").value("Ibrahima"))
                .andExpect(jsonPath("$[0].client.nom").value("FALL"))
                .andExpect(jsonPath("$[0].solde").value("3800.0"))
                .andExpect(jsonPath("$[1].numeroCompte").value(2))
                .andExpect(jsonPath("$[1].client.idClient").value(1))
                .andExpect(jsonPath("$[1].client.prenom").value("Ibrahima"))
                .andExpect(jsonPath("$[1].client.nom").value("FALL"))
                .andExpect(jsonPath("$[1].solde").value("14325.35"));

    }
}