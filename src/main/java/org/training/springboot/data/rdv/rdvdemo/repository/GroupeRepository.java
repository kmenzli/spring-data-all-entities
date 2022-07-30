package org.training.springboot.data.rdv.rdvdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.training.springboot.data.rdv.rdvdemo.model.Groupe;

@Repository
public interface GroupeRepository  extends JpaRepository<Groupe, Long> {
    Groupe findByGroupeName(String groupeName);
}
