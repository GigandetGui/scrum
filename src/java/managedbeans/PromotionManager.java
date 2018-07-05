/*
 * To change this license header, choose License Headers in Article Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managedbeans;

import facades.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javabeans.Promotion;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class PromotionManager implements Serializable
{

   private List<Promotion> promotions;
   private Promotion promotionToEdit;
   private Promotion promotion;
   private Promotion promotionToAdd;

   @EJB
   private PromotionFacade promotionFacade;

   @PostConstruct
   public void init()
   {
      promotionToAdd = new Promotion();
   }

   public void createPromotion(ActionEvent actionEvent)
   {
      promotionFacade.create(promotionToAdd);
      promotionToAdd = new Promotion();
      addMessage("Promotion ajouté avec succès !");
   }

   public void deletePromotion(Promotion pro)
   {
      promotionFacade.remove(pro);
      promotions.remove(pro);
   }


   public String editPromotion(Promotion pro)
   {
      promotion = pro;
      return "toShowPromotion";
   }
   
      public String updatePromotion(Promotion pro)
   {
//      promotionFacade.edit(promotion);
//      return "toIndex";
      promotionToEdit.setTitre(pro.getTitre());
      promotionFacade.edit(promotionToEdit);
      promotionToEdit = new Promotion();
      return "toIndex";
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
}