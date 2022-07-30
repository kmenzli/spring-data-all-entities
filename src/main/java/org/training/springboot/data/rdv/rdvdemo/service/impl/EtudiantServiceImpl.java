package org.training.springboot.data.rdv.rdvdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.training.springboot.data.rdv.rdvdemo.model.Etudiant;
import org.training.springboot.data.rdv.rdvdemo.repository.EtudiantRepository;
import org.training.springboot.data.rdv.rdvdemo.service.EtudiantService;

@Transactional
@Service
public class EtudiantServiceImpl implements EtudiantService {
    @Autowired
    EtudiantRepository etudiantRepository;
    @Override
    public Etudiant createEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }
}
