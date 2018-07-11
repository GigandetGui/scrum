/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author iLaziKx
 */
@Entity
@Table(name = "categorie_critere_entretien")
public class Entretien_categorie_critere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie_critere_entretien", nullable = false, length = 255)
    private int idCategorie_critere;

    @ManyToOne
    @JoinColumn(name = "fk_categorieCritere")
    private Categorie_critere categorieCritere;

    @ManyToOne
    @JoinColumn(name = "fk_entretien")
    private Entretien entretien;

    @Column(name = "observation")
    private String observation;

    public Entretien_categorie_critere(int idCategorie_critere, Categorie_critere categorieCritere, Entretien entretien, String observation) {
        this.idCategorie_critere = idCategorie_critere;
        this.categorieCritere = categorieCritere;
        this.entretien = entretien;
        this.observation = observation;
    }

    public Entretien_categorie_critere() {

    }

    public int getIdCategorie_critere() {
        return idCategorie_critere;
    }

    public void setIdCategorie_critere(int idCategorie_critere) {
        this.idCategorie_critere = idCategorie_critere;
    }

    public Categorie_critere getCategorieCritere() {
        return categorieCritere;
    }

    public void setCategorieCritere(Categorie_critere categorieCritere) {
        this.categorieCritere = categorieCritere;
    }

    public Entretien getEntretien() {
        return entretien;
    }

    public void setEntretien(Entretien entretien) {
        this.entretien = entretien;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

}
