/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

@Entity
@Table(name = "entreprise")
public class Entreprise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entreprise")
    private int id;
    @Column(name = "nom_entreprise")
    private String nom;
    @Column(name = "statut_juridique_entreprise", nullable = true)
    private String statutJuridique;
    @Column(name = "nombre_employe_entreprise", nullable = true)
    private int nombreEmploye;
    @Column(name = "cp_entreprise", nullable = true)
    private int codePostal;
    @Column(name = "ville_entreprise", nullable = true)
    private String ville;
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy="entreprise")
    private List<Tuteur> tuteurs;

//   @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
//   private List<Candidat> candidats;
    public Entreprise() {

    }

    public Entreprise(int id, String nom, String statutJuridique, int nombreEmploye, int codePostal, String ville, List<Tuteur> tuteurs) {
        this.id = id;
        this.nom = nom;
        this.statutJuridique = statutJuridique;
        this.nombreEmploye = nombreEmploye;
        this.codePostal = codePostal;
        this.ville = ville;
        this.tuteurs = tuteurs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    public void setStatutJuridique(String statutJuridique) {
        this.statutJuridique = statutJuridique;
    }

    public int getNombreEmploye() {
        return nombreEmploye;
    }

    public void setNombreEmploye(int nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }

    public int getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(int codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public List<Tuteur> getTuteurs() {
        return tuteurs;
    }

    public void setTuteurs(List<Tuteur> tuteurs) {
        this.tuteurs = tuteurs;
    }

    

   

//
//   public List<Candidat> getCommentaires()
//   {
//      return candidats;
//   }
//
//   public void setCommentaires(List<Candidat> commentaires)
//   {
//      this.candidats = commentaires;
//   }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Entreprise)) {
            return false;
        }
        Entreprise article = (Entreprise) o;
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
