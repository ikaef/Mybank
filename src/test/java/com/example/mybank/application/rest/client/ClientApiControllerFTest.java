package com.example.mybank.application.rest.client;


import com.example.mybank.domain.entities.Client;
import com.example.mybank.infrastructure.database.client.ClientDatabase;
import com.example.mybank.infrastructure.database.client.ClientDatabaseRepository;
import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class ClientApiControllerFTest {

    /* ICI J'AI FAIS LE CHOIX DE JOUER LES TESTS SUR LA BASE DE PROD, PARCEQUE JE N'AI PAS EU LE TEMPS
    DE CONFIGURER UNE BASE DE DONNEES POUR LES TESTS*/

    @Autowired
    private MockMvc mockMvc;

    @Test
    void doitRécupérerUnClientParID() throws Exception {
        var idIbrahimaFALL = 1;
        mockMvc.perform(get("http://localhost:8080/client/{id}",idIbrahimaFALL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idClient").value(idIbrahimaFALL))
                .andExpect(jsonPath("$.prenom").value("Ibrahima"))
                .andExpect(jsonPath("$.nom").value("FALL"));
    }
    @Test
    void doitRetournerClientIntrouvableException() throws Exception {
        var idClientInexistant = 20;
        mockMvc.perform(get("http://localhost:8080/client/{id}", idClientInexistant)).andExpect(status().isNotFound());
    }
    @Test
    void doitRetournerLaListeDesClients() throws Exception {
        var idIbrahimaFALL = 1;
        mockMvc.perform(get("http://localhost:8080/client/all")).andExpect(status().isOk());
    }

}
