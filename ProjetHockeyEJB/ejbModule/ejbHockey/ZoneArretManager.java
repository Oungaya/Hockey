package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
@LocalBean

public class ZoneArretManager implements ZoneArretManagerRemote {

	public ZoneArretManager() {}
	@PersistenceContext
	EntityManager em;
	public ZoneArret rechercherZoneArret(int id) {
		return em.find(ZoneArret.class, id);
	}
	public List<ZoneArret> listerZoneArret() {
		return em.createNamedQuery("selectionToutZoneArret").getResultList(); 
	}
}