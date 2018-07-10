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
public class Entreprise implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_entreprise")
   private int id;
   @Column(name = "nom_entreprise")
   private String nom;
   @Column(name = "statut_juridique_entreprise", nullable=true)
   private String statutJuridique;
   @Column(name = "nombre_employe_entreprise", nullable=true)
   private String nombreEmploye;

//   @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
//   private List<Candidat> candidats;

   public Entreprise()
   {
       
   }

    public Entreprise(int id, String titre, String statutJuridique, String nombreEmploye) {
        this.id = id;
        this.nom = titre;
        this.statutJuridique = statutJuridique;
        this.nombreEmploye = nombreEmploye;
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




    public String getNombreEmploye() {
        return nombreEmploye;
    }

    public void setNombreEmploye(String nombreEmploye) {
        this.nombreEmploye = nombreEmploye;
    }

    public String getStatutJuridique() {
        return statutJuridique;
    }

    public void setStatutJuridique(String statutJuridique) {
        this.statutJuridique = statutJuridique;
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
   public boolean equals(Object o)
   {
      if (this == o)
      {
         return true;
      }
      if (!(o instanceof Entreprise))
      {
         return false;
      }
      Entreprise article = (Entreprise) o;
      return Objects.equals(getId(), article.getId());
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(getId());
   }
}
