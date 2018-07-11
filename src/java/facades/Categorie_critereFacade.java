/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javabeans.Categorie_critere;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author iLaziKx
 */
@Stateless
public class Categorie_critereFacade extends AbstractFacade<Categorie_critere> {

    @PersistenceContext(unitName = "scrumPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public Categorie_critereFacade() {
        super(Categorie_critere.class);
    }
    
}
