package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
@LocalBean

public class ZoneTirManager implements ZoneTirManagerRemote {

	public ZoneTirManager() {}
	@PersistenceContext
	EntityManager em;
	public ZoneTir rechercherZoneTir(int id) {
		return em.find(ZoneTir.class, id);
	}
	public List<ZoneTir> listerZoneTir() {
		return em.createNamedQuery("selectionToutZoneTir").getResultList(); 
	}
}