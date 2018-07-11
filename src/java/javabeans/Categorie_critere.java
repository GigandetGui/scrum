/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author iLaziKx
 */
@Entity
@Table(name = "categorie_critere")
public class Categorie_critere implements Serializable {

    private static final long serialVersionUID = -5892169641074303723L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie_critere", nullable = false, length = 255)
    private int idCategorie_critere;

    @Column(name = "libelle")
    private String libelle;

    public Categorie_critere(int idCategorie_critere, List<Critere> critere, String libelle) {
        this.idCategorie_critere = idCategorie_critere;
        this.libelle = libelle;
    }

    public Categorie_critere() {

    }

    public int getIdCategorie_critere() {
        return idCategorie_critere;
    }

    public void setIdCategorie_critere(int idCategorie_critere) {
        this.idCategorie_critere = idCategorie_critere;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

}
