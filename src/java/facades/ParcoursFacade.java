/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javabeans.Parcours;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nouvel utilisateur
 */
@Stateless
public class ParcoursFacade extends AbstractFacade<Parcours> {

    @PersistenceContext(unitName = "scrumPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ParcoursFacade() {
        super(Parcours.class);
    }
    
}
