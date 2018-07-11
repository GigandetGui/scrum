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
import javabeans.Entreprise;
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
public class EntrepriseManager implements Serializable
{

   private List<Entreprise> entreprises;
   private Entreprise entrepriseToEdit;
   private Entreprise entreprise;
   private Entreprise entrepriseToAdd;

   @EJB
   private EntrepriseFacade entrepriseFacade;

   @PostConstruct
   public void init()
   {
      entrepriseToAdd = new Entreprise();
      entreprise = new Entreprise();
   }

   public String createEntreprise()
   {
      entrepriseFacade.create(entrepriseToAdd);
      entrepriseToAdd = new Entreprise();
      addMessage("Entreprise ajouté avec succès !");
      return "toIndexEntreprise";
   }

   public String deleteEntreprise(Entreprise entr)
   {
      entrepriseFacade.remove(entr);
      entreprises.remove(entr);
      addMessage("Entreprise supprimée avec succès !");
      
      return "toIndexEntreprise";
   }


   public String editEntreprise(Entreprise entr)
   {
      entrepriseToEdit = entr;
      return "toEditEntreprise";
   }
   
   public String updateEntreprise(Entreprise entr)
   {
      entrepriseToEdit.setNom(entr.getNom());
      entrepriseFacade.edit(entrepriseToEdit);
      entrepriseToEdit = new Entreprise();
      return "toIndexEntreprise";
   }

   public void addMessage(String summary)
   {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
      FacesContext.getCurrentInstance().addMessage(null, message);
   }

   public List<Entreprise> getEntreprises()
   {
      try
      {
         entreprises = entrepriseFacade.findAll();
         return entreprises;

      } catch (EJBException ee)
      {
         return entreprises = new ArrayList<>();
      }
   }

   public void setEntreprises(List<Entreprise> entreprises)
   {
      this.entreprises = entreprises;
   }

   public Entreprise getEntreprise()
   {
      return entreprise;
   }

   public void setEntreprise(Entreprise entreprise)
   {
      this.entreprise = entreprise;
   }

   public Entreprise getEntrepriseToAdd()
   {
      return entrepriseToAdd;
   }

   public void setEntrepriseToAdd(Entreprise entrepriseToAdd)
   {
      this.entrepriseToAdd = entrepriseToAdd;
   }

   public Entreprise getEntrepriseToEdit()
   {
      return entrepriseToEdit;
   }

   public void setEntrepriseToEdit(Entreprise entrepriseToEdit)
   {
      this.entrepriseToEdit = entrepriseToEdit;
   }
   
}
