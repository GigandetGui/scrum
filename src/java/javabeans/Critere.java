/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author iLaziKx
 */
@Entity
@Table(name = "critere")
public class Critere implements Serializable {

    private static final long serialVersionUID = -5892169641074303723L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_critere", nullable = false, length = 255)
    private int idCandidat;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "niveau")
    private int niveau;

    @ManyToOne
    @JoinColumn(name = "fk_categorieCritere")
    private Categorie_critere categorieCritere;

    public Critere() {

    }

    public Critere(int idCandidat, String libelle, int niveau, Categorie_critere categorieCritere) {
        this.idCandidat = idCandidat;
        this.libelle = libelle;
        this.niveau = niveau;
        this.categorieCritere = categorieCritere;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getNiveau() {
        return niveau;
    }

    public void setNiveau(int niveau) {
        this.niveau = niveau;
    }

    public Categorie_critere getCategorieCritere() {
        return categorieCritere;
    }

    public void setCategorieCritere(Categorie_critere categorieCritere) {
        this.categorieCritere = categorieCritere;
    }
    
    

}
