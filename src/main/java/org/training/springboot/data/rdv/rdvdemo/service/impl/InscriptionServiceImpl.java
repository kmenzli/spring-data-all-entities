package org.training.springboot.data.rdv.rdvdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.springboot.data.rdv.rdvdemo.model.Inscription;
import org.training.springboot.data.rdv.rdvdemo.repository.InscriptionRepository;
import org.training.springboot.data.rdv.rdvdemo.service.InscriptionService;

import java.util.List;

@Service
@Transactional
public class InscriptionServiceImpl implements InscriptionService {
    @Autowired
    InscriptionRepository inscriptionRepository;

    public void createInscription(Inscription inscription) {
        inscriptionRepository.save(inscription);
    }

    @Override
    public List<Inscription> findByCoursNom(String coursName) {
        return inscriptionRepository.findByCoursNom(coursName);
    }

    @Override
    public Inscription findByEtudiantNom(String etudiantName) {
        return inscriptionRepository.findByEtudiantNom(etudiantName);
    }
}
