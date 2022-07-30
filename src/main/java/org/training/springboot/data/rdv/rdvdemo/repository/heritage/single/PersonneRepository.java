package org.training.springboot.data.rdv.rdvdemo.repository.heritage.single;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.table.Personne;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
