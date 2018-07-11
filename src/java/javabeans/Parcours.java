/*
 * To change this license header, choose License Headers in Article Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Admin
 */
@Entity
@Table(name = "parcours")
public class Parcours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_parcours")
    private int id;
    @Column(name = "actuelle")
    private String actuelle;
    @Column(name = "etablissement")
    private String etablissement;
    @Column(name = "diplome")
    private Boolean diplome;
    @Column(name = "commentaire")
    private String commentaire;

    public Parcours() {
    }

    public Parcours(int id, String actuelle, String etablissement, Boolean diplome, String commentaire) {
        this.id = id;
        this.actuelle = actuelle;
        this.etablissement = etablissement;
        this.diplome = diplome;
        this.commentaire = commentaire;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActuelle() {
        return actuelle;
    }

    public void setActuelle(String actuelle) {
        this.actuelle = actuelle;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public Boolean getDiplome() {
        return diplome;
    }

    public void setDiplome(Boolean diplome) {
        this.diplome = diplome;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Parcours)) {
            return false;
        }
        Parcours article = (Parcours) o;
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

}
