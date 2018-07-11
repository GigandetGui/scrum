/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

/**
 *
 * @author dedeh
 */
@Entity
@Table(name = "entretien")
public class Entretien implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Entretien")
    private int id;
    @Column(name = "avis_Entretien")
    private String avis;
    @Column(name = "dte_Entretien")
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dateEntretien;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_parcours", unique = false, nullable = false, updatable = true)
    private Parcours parcours;

    @OneToOne(optional = false)
    @JoinColumn(name = "id_Candidat", unique = false, nullable = false, updatable = true)
    private Candidat candidat;
    
    @Column(name = "is_apprenti")
    private Boolean is_apprenti;


    public Entretien() {
    }

    public Entretien(int id, String avis, LocalDate dateEntretien, Parcours parcours, Candidat candidat) {
        this.id = id;
        this.avis = avis;
        this.dateEntretien = dateEntretien;
        this.parcours = parcours;
        this.candidat = candidat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAvis() {
        return avis;
    }

    public void setAvis(String avis) {
        this.avis = avis;
    }

    public LocalDate getDateEntretien() {
        return dateEntretien;
    }

    public void setDateEntretien(LocalDate dateEntretien) {
        this.dateEntretien = dateEntretien;
    }

    public Parcours getParcours() {
        return parcours;
    }

    public void setParcours(Parcours parcours) {
        this.parcours = parcours;
    }

    public Candidat getCandidat() {
        return candidat;
    }

    public void setCandidat(Candidat candidat) {
        this.candidat = candidat;
    }

}
