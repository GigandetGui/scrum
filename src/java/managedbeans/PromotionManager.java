/*
 * To change this license header, choose License Headers in Article Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import facades.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javabeans.Candidat;
import javabeans.Promotion;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ManagedBean
@SessionScoped
public class PromotionManager implements Serializable
{

   private List<Promotion> promotions;
   private Promotion promotionToEdit;
   private Promotion promotion;
   private Promotion promotionToAdd;

    //A SUPPRIMER APRES TEST 
   private Candidat candidat;
   
   @EJB
   private PromotionFacade promotionFacade;
   
//A SUPPRIMER APRES TEST 
   @EJB
   private CandidatFacade candidatFacade;

   @PostConstruct
   public void init()
   {
      promotionToAdd = new Promotion();
      promotion = new Promotion();
   }

   public String createPromotion()
   {       
       
      promotionFacade.create(promotionToAdd);
      
       // TEST
        //A SUPPRIMER APRES TEST 
       candidat = new Candidat();
       candidat.setCodePostal("25000");
       candidat.setDteNaissance(LocalDate.now());
       candidat.setEmail("dd@ff.fr");
       candidat.setNom("GG");
       candidat.setPrenom("dd");
       candidat.setPortable("0661186152");
       candidat.setRue("8 dsqdq");
       candidat.setSecuSocial("2553212");
       candidat.setTel("206050");
       candidat.setVille("Besancon");
       
       candidat.getPromotions().add(promotionToAdd);
       //candidat.addPromotion(promotionToAdd);
       candidatFacade.create(candidat);
       promotionFacade.edit(promotionToAdd);
       //END TEST
       
      
       promotionToAdd = new Promotion();
      addMessage("Promotion ajouté avec succès !");
      return "toIndexPromotion";
   }

   public void deletePromotion(Promotion promo)
   {
      promotionFacade.remove(promo);
      promotions.remove(promo);
      addMessage("Promotion supprimée avec succès !");
   }


   public String editPromotion(Promotion promo)
   {
      promotionToEdit = promo;
      return "toEditPromotion";
   }
   
   public String updatePromotion(Promotion promo)
   {
      promotionToEdit.setTitre(promo.getTitre());
      promotionFacade.edit(promotionToEdit);
      promotionToEdit = new Promotion();
      return "toIndexPromotion";
   }

   public void addMessage(String summary)
   {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
      FacesContext.getCurrentInstance().addMessage(null, message);
   }

   public List<Promotion> getPromotions()
   {
      try
      {
         promotions = promotionFacade.findAll();
         return promotions;

      } catch (EJBException ee)
      {
         return promotions = new ArrayList<>();
      }
   }

   public void setPromotions(List<Promotion> promotions)
   {
      this.promotions = promotions;
   }

   public Promotion getPromotion()
   {
      return promotion;
   }

   public void setPromotion(Promotion promotion)
   {
      this.promotion = promotion;
   }

   public Promotion getPromotionToAdd()
   {
      return promotionToAdd;
   }

   public void setPromotionToAdd(Promotion promotionToAdd)
   {
      this.promotionToAdd = promotionToAdd;
   }

   public Promotion getPromotionToEdit()
   {
      return promotionToEdit;
   }

   public void setPromotionToEdit(Promotion promotionToEdit)
   {
      this.promotionToEdit = promotionToEdit;
   }
   
}
