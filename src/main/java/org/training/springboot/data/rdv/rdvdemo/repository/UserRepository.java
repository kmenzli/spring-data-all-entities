package org.training.springboot.data.rdv.rdvdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.training.springboot.data.rdv.rdvdemo.model.Utilisateur;

@Repository
public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    Utilisateur findByUserName(String username);
}
