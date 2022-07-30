package org.training.springboot.data.rdv.rdvdemo.service;


import org.training.springboot.data.rdv.rdvdemo.model.Inscription;

import java.util.List;

public interface InscriptionService {
    void createInscription(Inscription inscription);
    List<Inscription> findByCoursNom(String coursName);
    Inscription findByEtudiantNom(String etudiantName);


}
