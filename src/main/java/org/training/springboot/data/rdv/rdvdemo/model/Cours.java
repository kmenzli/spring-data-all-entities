package org.training.springboot.data.rdv.rdvdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name  ="COURS")
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private int volume;

    @OneToMany(mappedBy = "cours",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Inscription> inscriptions = new ArrayList<>();

    public Cours(String nom, int volume) {
        this.nom = nom;
        this.volume = volume;
    }

    public void addInscription (Inscription inscription) {
        this.inscriptions.add(inscription);
        inscription.setCours(this);
    }

    public void removeInscription(Inscription inscription) {
        this.inscriptions.remove(inscription);
        inscription.setCours(null);
    }
}
