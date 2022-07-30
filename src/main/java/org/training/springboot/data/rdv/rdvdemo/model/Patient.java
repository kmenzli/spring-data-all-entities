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
@Table(name  ="PATIENT")
public class Patient implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "patient")
    private List<RendezVous> rdvs = new ArrayList<>();

    public void addRdv(RendezVous rdv) {
        this.rdvs.add(rdv);
        rdv.setPatient(this);
    }
    public void removeRdv(RendezVous rdv) {
        this.rdvs.remove(rdv);
        rdv.setPatient(null);
    }
}
