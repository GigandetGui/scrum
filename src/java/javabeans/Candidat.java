/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javabeans;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import tools.LocalDateAttributeConverter;

/**
 *
 * @author Ikikay
 */
@Entity
@Table(name = "candidat")
public class Candidat implements Serializable {

    private static final long serialVersionUID = -5892169641074303723L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_candidat", nullable = false, length = 255)
    private int idCandidat;

    @Column(name = "nom", nullable = false, length = 255)
    private String nom;
    
    @Column(name = "prenom", nullable = false, length = 255)
    private String prenom;
    
    @Column(name = "code_postal", nullable = false, length = 5)
    private String codePostal;
    
    @Column(name = "ville", nullable = false, length = 255)
    private String ville;
    
    @Column(name = "rue", nullable = false, length = 255)
    private String rue;
    
    @Column(name = "dte_naissance", nullable = false, length = 255)
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate dteNaissance;
    
    @Column(name = "tel", nullable = false, length = 10)
    private String tel;

    @Column(name = "portable", nullable = false, length = 10)
    private String portable;

    @Column(name = "email", nullable = false, length = 255)
    private String email;

    @Column(name = "secu_social", nullable = false, length = 15)
    private String secuSocial;

    @Column(name = "permis_a")
    private Boolean permisA;

    @Column(name = "permis_b")
    private Boolean permisB;    

    @Column(name = "voiture")
    private Boolean voiture; 
    
    @Column(name = "moto")
    private Boolean moto;   

    @Column(name = "scooter")
    private Boolean scooter;   
   
    
    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Promotion> promotions = new HashSet<Promotion>();
    
    
    public Set<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Set<Promotion> promotions) {
        this.promotions = promotions;
    }
    
    public void addPromotion(Promotion promotion) {
        promotions.add(promotion);
       promotion.getCandidats().add(this);
    }
 
    public void removePromotion(Promotion promotion) {
        promotions.remove(promotion);
        promotion.getCandidats().remove(this);
    }
    
    public Candidat() {
    }    
    
    public Candidat(int idCandidat, String nom, String prenom, String codePostal, String ville, String rue, LocalDate dteNaissance, String tel, String portable, String email, String secuSocial, Boolean permisA, Boolean permisB, Boolean voiture, Boolean moto, Boolean scooter) {
        this.idCandidat = idCandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.codePostal = codePostal;
        this.ville = ville;
        this.rue = rue;
        this.dteNaissance = dteNaissance;
        this.tel = tel;
        this.portable = portable;
        this.email = email;
        this.secuSocial = secuSocial;
        this.permisA = permisA;
        this.permisB = permisB;
        this.voiture = voiture;
        this.moto = moto;
        this.scooter = scooter;
    }

    public int getIdCandidat() {
        return idCandidat;
    }

    public void setIdCandidat(int idCandidat) {
        this.idCandidat = idCandidat;
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

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public LocalDate getDteNaissance() {
        return dteNaissance;
    }

    public void setDteNaissance(LocalDate dteNaissance) {
        this.dteNaissance = dteNaissance;
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

    public String getSecuSocial() {
        return secuSocial;
    }

    public void setSecuSocial(String secuSocial) {
        this.secuSocial = secuSocial;
    }

    public Boolean getPermisA() {
        return permisA;
    }

    public void setPermisA(Boolean permisA) {
        this.permisA = permisA;
    }

    public Boolean getPermisB() {
        return permisB;
    }

    public void setPermisB(Boolean permisB) {
        this.permisB = permisB;
    }

    public Boolean getVoiture() {
        return voiture;
    }

    public void setVoiture(Boolean voiture) {
        this.voiture = voiture;
    }

    public Boolean getMoto() {
        return moto;
    }

    public void setMoto(Boolean moto) {
        this.moto = moto;
    }

    public Boolean getScooter() {
        return scooter;
    }

    public void setScooter(Boolean scooter) {
        this.scooter = scooter;
    }
    
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
      Candidat cand = (Candidat) o;
      return Objects.equals(getIdCandidat(), cand.getIdCandidat());
   }

   @Override
   public int hashCode()
   {
      return Objects.hash(getIdCandidat());
   }

    
    
}
