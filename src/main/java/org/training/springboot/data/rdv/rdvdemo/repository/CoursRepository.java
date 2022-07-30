package org.training.springboot.data.rdv.rdvdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.training.springboot.data.rdv.rdvdemo.model.Cours;

@Repository
public interface CoursRepository extends JpaRepository<Cours, Long> {
}
