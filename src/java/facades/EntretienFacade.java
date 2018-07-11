/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javabeans.Entretien;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author dedeh
 */
@Stateless
public class EntretienFacade extends AbstractFacade<Entretien> {

    @PersistenceContext(unitName = "scrumPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EntretienFacade() {
        super(Entretien.class);
    }
    
}
