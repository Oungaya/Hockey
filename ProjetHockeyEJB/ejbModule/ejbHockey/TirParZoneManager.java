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
	public void ajouterTirParZone(ZoneTir zonetir, ZoneArret zonearret, Gardien gardien, Match match, int result){
		

		List<TirParZone> tirparzonelist = em.createNamedQuery("selectionUnTirParZone")
				.setParameter("but", result)
				.setParameter("zonetir", zonetir.getId())
				.setParameter("zonearret", zonearret.getId())
				.setParameter("match", match.getId())
				.setParameter("gardien", gardien.getId()).getResultList();
		
		if(tirparzonelist.isEmpty()){
			TirParZone tirparzone = new TirParZone(1, zonetir, zonearret, gardien, match, result);
			em.merge(tirparzone);
		}else{
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