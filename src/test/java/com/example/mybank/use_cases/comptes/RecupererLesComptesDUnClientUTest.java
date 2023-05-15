package com.example.mybank.use_cases.comptes;

import com.example.mybank.domain.entities.Client;
import com.example.mybank.domain.entities.Compte;
import com.example.mybank.use_cases.client.RecupererClientParId;
import com.example.mybank.use_cases.ports.ComptePort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class RecupererLesComptesDUnClientUTest {
    @Mock
    private ComptePort comptePort;

    @Mock
    RecupererClientParId récupérerClientParId;
    @InjectMocks
    RecupererLesComptesDUnClient récupérerLesComptesDUnClient;

    @Test
    void doitRécupérerLesComptesDunClientSiNuméroCompteValide() {
        var idClient = 1;
        var numeroCompte = 1;
        var client = Client.builder().idClient(idClient).prenom("Ibrahima").nom("FALL").build();
        var compte = Compte.builder()
                .numeroCompte(numeroCompte)
                .client(client)
                .solde(new BigDecimal("250"))
                .build();
        given(comptePort.récupérérLesComptesDUnClient(client.getIdClient())).willReturn(List.of(compte));
        given(récupérerClientParId.executer(idClient)).willReturn(client);

        var compteObtenu = récupérerLesComptesDUnClient.exécuter(idClient);

        assertThat(compteObtenu.get(0)).isEqualTo(compte);
    }
}