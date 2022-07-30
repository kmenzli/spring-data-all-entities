package org.training.springboot.data.rdv.rdvdemo.repository.heritage.two;

import org.springframework.data.jpa.repository.JpaRepository;
import org.training.springboot.data.rdv.rdvdemo.model.heritage.two.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
