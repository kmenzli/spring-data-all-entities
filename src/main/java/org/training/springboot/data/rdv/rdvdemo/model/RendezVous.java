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
@Table(name = "RENDEZ_VOUS")
public class RendezVous implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    Date dateRendezVous;

    @ManyToOne(optional = true)
    @JoinColumn(name = "patient_id")
    private Patient patient;

    @ManyToOne(optional = true)
    @JoinColumn(name = "medecin_id")
    private Medecin medecin;

    @OneToOne(mappedBy = "rendezVous", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Consultation consultation;

    public void setConsultation(Consultation consultation) {
        if (consultation == null) {
            if (this.consultation != null) {
                this.consultation.setRendezVous(null);
            }
        } else {
            consultation.setRendezVous(this);
        }
        this.consultation = consultation;
    }
}
