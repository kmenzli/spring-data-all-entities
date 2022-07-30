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
@Table(name = "GROUPE")
public class Groupe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String groupeName;

    @ManyToMany(mappedBy = "groupes")
    private Set<Utilisateur> utilisateurs = new HashSet<>();

    public Groupe(String groupeName) {
        this.groupeName = groupeName;
    }

    public void addUtilisateur (Utilisateur utilisateur) {
        this.utilisateurs.add(utilisateur);
        utilisateur.getGroupes().add(this);
    }

    public void removeUtilisateur (Utilisateur utilisateur) {
        this.utilisateurs.remove(utilisateur);
        utilisateur.getGroupes().remove(this);
    }
}
