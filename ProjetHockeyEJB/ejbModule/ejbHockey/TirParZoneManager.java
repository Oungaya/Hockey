package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
@LocalBean

public class TirParZoneManager implements TirParZoneManagerRemote {

	public TirParZoneManager() {}
	@PersistenceContext
	EntityManager em;
	public TirParZone ajouterTirParZone(TirParZone tirParZone) {
		em.persist(tirParZone);
		return tirParZone;
	}
	public List<TirParZone> listerTirParZone() {
		return em.createNamedQuery("selectionToutTirParZone").getResultList(); 
	}
	
}