/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

@Entity
@Table(name = "promotion")

public class Promotion implements Serializable
{
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id_promotion")
   private int id;
   @Column(name = "titre_promotion")
   private String titre;
   
   @ManyToMany(mappedBy = "promotions", fetch = FetchType.LAZY)
    private Set<Candidat> candidats = new HashSet<Candidat>();
   
      public void addCandidat(Candidat candidat) {
        candidats.add(candidat);
        candidat.getPromotions().add(this);
    }
 
    public void removeCandidat(Candidat candidat) {
        candidats.remove(candidat);
        candidat.getPromotions().remove(this);
    }

    public Set<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(Set<Candidat> candidats) {
        this.candidats = candidats;
    }
    
    
    
//   @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
//   private List<Candidat> candidats;

   public Promotion()
   {
   }

   public Promotion(int id, String titre)
   {
      this.id = id;
      this.titre = titre;
   }

   public int getId()
   {
      return id;
   }

   public void setId(int id)
   {
      this.id = id;
   }

   public String getTitre()
   {
      return titre;
   }

   public void setTitre(String titre)
   {
      this.titre = titre;
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
      if (!(o instanceof Promotion))
      {
         return false;
      }
      Promotion article = (Promotion) o;
      return Objects.equals(getId(), article.getId());
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(getId());
   }
}
