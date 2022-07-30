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
@Table(name  ="ETUDIANT")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;

    @OneToMany(mappedBy = "etudiant",orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Inscription> inscriptions = new ArrayList<>();

    public Etudiant(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    public void addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
        inscription.setEtudiant(this);
    }

    public void removeInscription(Inscription inscription) {
        this.inscriptions.remove(inscription);
        inscription.setEtudiant(null);
    }
}
