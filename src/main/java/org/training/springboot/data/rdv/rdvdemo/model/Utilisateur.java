package org.training.springboot.data.rdv.rdvdemo.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "UTILISTEUR")
public class Utilisateur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String userName;
    private String password;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "UTILISATEURS_GROUPES",
            joinColumns = {
                    @JoinColumn(name = "ID_UTILISATEUR"),},
            inverseJoinColumns = {
                    @JoinColumn(name = "ID_GROUPE")
            })
    private Set<Groupe> groupes = new HashSet<>();

    public Utilisateur(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void addGroupe(Groupe groupe) {
        this.groupes.add(groupe);
        groupe.getUtilisateurs().add(this);
    }

    public void removeGroupe(Groupe groupe) {
        this.groupes.remove(groupe);
        groupe.getUtilisateurs().remove(this);
    }
}
