package com.example.mybank.infrastructure.database.compte;

import com.example.mybank.domain.entities.Compte;
import com.example.mybank.domain.exceptions.CompteInexistantException;
import com.example.mybank.domain.exceptions.CompteInexistantPourCeClientException;
import com.example.mybank.domain.mappers.CompteDatabaseMapper;
import com.example.mybank.use_cases.ports.ComptePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class CompteAdapter implements ComptePort {
    private final CompteRepository compteRepository;

    @Override
    public Compte récupérerCompteParId(int numéroCompte) {
        var compteRetourné = compteRepository.getComptesByNuméroCompte(numéroCompte);
        if (compteRetourné.isEmpty())
            throw new CompteInexistantException(numéroCompte);

        return CompteDatabaseMapper.toCompte(compteRetourné.get());
    }

    @Override
    public List<Compte> récupérérLesComptesDUnClient(int idClient) {
        var comptesRetournés = compteRepository.getComptesByClient_IdClient(idClient);
        if (comptesRetournés.isEmpty())
            throw new CompteInexistantPourCeClientException(idClient);

        return CompteDatabaseMapper.toComptes(comptesRetournés);
    }

    @Override
    public void majCompte(Compte compte){

        compteRepository.save(CompteDatabaseMapper.toCompteDatabase(compte));
    }
}
