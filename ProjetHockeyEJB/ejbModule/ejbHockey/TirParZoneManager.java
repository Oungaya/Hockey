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
	public void ajouterTirParZone(int idZoneTir, int idZoneArret, int idGardien, int idMatch){
		List<TirParZone> tirparzonelist = em.createNamedQuery("selectionUnTirParZone")
				.setParameter("zonetir", idZoneTir)
				.setParameter("zonearret", idZoneArret)
				.setParameter("match", idMatch)
				.setParameter("gardien", idGardien).getResultList();
		if(tirparzonelist.isEmpty()){
			TirParZone tirParZone = new TirParZone(1, idZoneTir, idZoneArret, idGardien, idMatch);
			em.persist(tirParZone);
		}
		else {
			TirParZone tirParZone = tirparzonelist.get(0);
			tirParZone.setNbTir(tirParZone.getNbTir()+1);
			em.merge(tirParZone);
		}
			
	}
	public TirParZone ajouterTirParZone(TirParZone tirParZone) {
		em.persist(tirParZone);
		return tirParZone;
	}
	public List<TirParZone> listerTirParZone() {
		return em.createNamedQuery("selectionToutTirParZone").getResultList(); 
	}
	
}