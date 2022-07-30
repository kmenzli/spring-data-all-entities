package org.training.springboot.data.rdv.rdvdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.springboot.data.rdv.rdvdemo.model.Cours;
import org.training.springboot.data.rdv.rdvdemo.model.Etudiant;
import org.training.springboot.data.rdv.rdvdemo.model.Inscription;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {
    Inscription findByCours(Cours cours);
    Inscription findByEtudiant(Etudiant etudiant);
    Inscription findByCoursAndEtudiant(Cours cours, Etudiant etudiant);
    List<Inscription> findByCoursNom(String coursName);
    Inscription findByEtudiantNom(String etudiantName);
}
