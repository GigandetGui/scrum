/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

@Entity
@Table(name = "tuteur")
public class Tuteur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tuteur")
    private int id;
    @Column(name = "nom_tuteur")
    private String nom;
    @Column(name = "prenom", nullable=true , length = 255)
    private String prenom;
    @Column(name = "dteNaissance", nullable=true, length = 255)
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dteNaissance;

    @Column(name = "tel", nullable=true, length = 10)
    private String tel;

    @Column(name = "portable", nullable=true, length = 10)
    private String portable;

    @Column(name = "email", nullable=true, length = 255)
    private String email;
    
    @ManyToOne
    @JoinColumn(name="fk_entreprise")
    private Entreprise entreprise;

//   @OneToMany(cascade = CascadeType.ALL, mappedBy = "promotion")
//   private List<Candidat> candidats;
    public Tuteur() {

    }

    public Tuteur(int id, String nom, String prenom, LocalDate dteNaissance, String tel, String portable, String email, Entreprise entreprise) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.dteNaissance = dteNaissance;
        this.tel = tel;
        this.portable = portable;
        this.email = email;
        this.entreprise = entreprise;
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /* public String getDteNaissance() {
        return dteNaissance.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }*/
    
    public String getDteNaissance(){
        return dteNaissance.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void setDteNaissance(String dteNaissance) {
        
        this.dteNaissance = LocalDate.parse(dteNaissance,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPortable() {
        return portable;
    }

    public void setPortable(String portable) {
        this.portable = portable;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
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
        if (!(o instanceof Tuteur)) {
            return false;
        }
        Tuteur article = (Tuteur) o;
        return Objects.equals(getId(), article.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }
}
