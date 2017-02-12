package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
@LocalBean

public class GardienManager implements GardienManagerRemote {

	public GardienManager() {}
	@PersistenceContext
	EntityManager em;
	public Gardien rechercherGadien(int id) {
		return em.find(Gardien.class, id);
	}
	public List<Gardien> listerGardiens() {
		return em.createNamedQuery("selectionToutGardiens").getResultList(); 
	}
	
}
