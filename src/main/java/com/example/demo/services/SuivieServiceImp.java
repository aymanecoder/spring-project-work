package com.example.demo.services;

import com.example.demo.entities.Suivi;
import com.example.demo.repository.SuiviRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SuivieServiceImp implements SuivieService{
 private final SuiviRepository suiviRepository;
    @Override
    public List<Suivi> getAllSuivis() {
        return suiviRepository.findAll();
    }

    @Override
    public Suivi getSuiviById(Long id) {
        return suiviRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Suivi not found with id: " + id));
    }

    @Override
    public Suivi createSuivi(Suivi suivi) {
        return suiviRepository.save(suivi);
    }

    @Override
    public Suivi updateSuivi(Long id, Suivi suivi) {
        Suivi existingSuivi = getSuiviById(id);
        existingSuivi.setOffreCommercial(suivi.isOffreCommercial());
        existingSuivi.setMontant(suivi.getMontant());
        existingSuivi.setCompteRendu(suivi.getCompteRendu());
        existingSuivi.setTypePrestation(suivi.getTypePrestation());
        existingSuivi.setPov(suivi.getPov());
        return suiviRepository.save(existingSuivi);
    }

    @Override
    public void deleteSuivi(Long id) {
        Suivi existingSuivi = getSuiviById(id);
        suiviRepository.delete(existingSuivi);
    }
}
