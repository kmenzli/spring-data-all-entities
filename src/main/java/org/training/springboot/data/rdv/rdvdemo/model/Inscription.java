package org.training.springboot.data.rdv.rdvdemo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@Entity

@Table(name  ="INSCRIPTION")
public class Inscription implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    private int score;

    @ManyToOne(optional = true)
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    @ManyToOne(optional = true)
    @JoinColumn(name = "cours_id")
    private Cours cours;


    @Override
    public String toString() {
        return "Inscription{" +
                "id=" + id +
                ", date=" + date +
                ", score=" + score +
                ", etudiant=" + etudiant.getNom() +
                ", cours=" + cours.getNom() +
                '}';
    }
}
