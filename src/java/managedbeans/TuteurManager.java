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
import javabeans.Tuteur;
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
public class TuteurManager implements Serializable
{

   private List<Tuteur> tuteurs;
   private Tuteur tuteurToEdit;
   private Tuteur tuteur;
   private Tuteur tuteurToAdd;

   @EJB
   private TuteurFacade tuteurFacade;

   @PostConstruct
   public void init()
   {
      tuteurToAdd = new Tuteur();
      tuteur = new Tuteur();
   }

   public String createTuteur()
   {
      tuteurFacade.create(tuteurToAdd);
      tuteurToAdd = new Tuteur();
      addMessage("Tuteur ajouté avec succès !");
      return "toIndexTuteur";
   }

   public void deleteTuteur(Tuteur tut)
   {
      tuteurFacade.remove(tut);
      tuteurs.remove(tut);
      addMessage("Tuteur supprimée avec succès !");
   }


   public String editTuteur(Tuteur tut)
   {
      tuteurToEdit = tut;
      return "toEditTuteur";
   }
   
   public String updateTuteur(Tuteur tut)
   {
      tuteurToEdit.setNom(tut.getNom());
      tuteurFacade.edit(tuteurToEdit);
      tuteurToEdit = new Tuteur();
      return "toIndexTuteur";
   }

   public void addMessage(String summary)
   {
      FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
      FacesContext.getCurrentInstance().addMessage(null, message);
   }

   public List<Tuteur> getTuteurs()
   {
      try
      {
         tuteurs = tuteurFacade.findAll();
         return tuteurs;

      } catch (EJBException ee)
      {
         return tuteurs = new ArrayList<>();
      }
   }

   public void setTuteurs(List<Tuteur> tuteurs)
   {
      this.tuteurs = tuteurs;
   }

   public Tuteur getTuteur()
   {
      return tuteur;
   }

   public void setTuteur(Tuteur tuteur)
   {
      this.tuteur = tuteur;
   }

   public Tuteur getTuteurToAdd()
   {
      return tuteurToAdd;
   }

   public void setTuteurToAdd(Tuteur tuteurToAdd)
   {
      this.tuteurToAdd = tuteurToAdd;
   }

   public Tuteur getTuteurToEdit()
   {
      return tuteurToEdit;
   }

   public void setTuteurToEdit(Tuteur tuteurToEdit)
   {
      this.tuteurToEdit = tuteurToEdit;
   }
   
}
