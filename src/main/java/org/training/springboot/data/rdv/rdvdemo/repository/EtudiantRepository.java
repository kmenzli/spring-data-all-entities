package org.training.springboot.data.rdv.rdvdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.springboot.data.rdv.rdvdemo.model.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
