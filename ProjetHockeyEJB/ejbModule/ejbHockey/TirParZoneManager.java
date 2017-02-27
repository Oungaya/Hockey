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
	public void ajouterTirParZone(ZoneTir zonetir, ZoneArret zonearret, Gardien gardien, Match match, int but){
		

		List<TirParZone> tirparzonelist = em.createNamedQuery("selectionUnTirParZone")
				.setParameter("zonetir", zonetir.getId())
				.setParameter("zonearret", zonearret.getId())
				.setParameter("match", match.getId())
				.setParameter("gardien", gardien.getId()).getResultList();
		
		if(tirparzonelist.isEmpty()){
			TirParZone tirparzone = new TirParZone(1, zonetir, zonearret, gardien, match, but);
			em.merge(tirparzone);
		}else{
			TirParZone tirParZone = tirparzonelist.get(0);
			tirParZone.setNbTir(tirParZone.getNbTir()+1);
			tirParZone.setBut(tirParZone.getBut()+ but);
			em.merge(tirParZone);
		}
			
	}
	public TirParZone ajouterTirParZone(TirParZone tirParZone) {
		em.persist(tirParZone);
		return tirParZone;
	}
	
	public int[] nbTirParZoneTir(int idZone, int idGardien, int idMatch)
	{
		int[] tab = new int[2];
		tab[0] = 0;
		tab[1] = 0;
		List<TirParZone> zones =  em.createNamedQuery("selectionNbTirZoneTir")
				.setParameter("match", idMatch)
				.setParameter("gardien", idGardien)
				.setParameter("zonetir", idZone)
				.getResultList();
				
		for(int i=0; i<zones.size(); i++){
			tab[0] += zones.get(i).getNbTir();
			tab[1] += zones.get(i).getBut();
		}
		return tab;
	}
	
	public int[] nbTirParZoneArret(int idZone, int idGardien, int idMatch)
	{
		int[] tab = new int[2];
		tab[0] = 0;
		tab[1] = 0;
		List<TirParZone> zones =  em.createNamedQuery("selectionNbTirZoneArret")
				.setParameter("match", idMatch)
				.setParameter("gardien", idGardien)
				.setParameter("zonearret", idZone)
				.getResultList();
				
		for(int i=0; i<zones.size(); i++){
			tab[0] += zones.get(i).getNbTir();
			tab[1] += zones.get(i).getBut();
		}
		tab[1] = tab[0] - tab[1];
		
		
		return tab;
	}
	
	public int[] nbTirParZoneArretAll(int idZone, int idGardien)
	{
		int[] tab = new int[2];
		tab[0] = 0;
		tab[1] = 0;
		List<TirParZone> zones =  em.createNamedQuery("selectionNbTirZoneArretAll")
				.setParameter("gardien", idGardien)
				.setParameter("zonearret", idZone)
				.getResultList();
				
			for(int i=0; i<zones.size(); i++){
			tab[0] += zones.get(i).getNbTir();
			tab[1] += zones.get(i).getBut();
		}
		tab[1] = tab[0] - tab[1];
		return tab;
	}
	
	public int[] nbTirParZoneTirAll(int idZone, int idGardien)
	{
		int[] tab = new int[2];
		tab[0] = 0;
		tab[1] = 0;
		List<TirParZone> zones =  em.createNamedQuery("selectionNbTirZoneTirAll")
				.setParameter("gardien", idGardien)
				.setParameter("zonetir", idZone)
				.getResultList();
				
			for(int i=0; i<zones.size(); i++){
			tab[0] += zones.get(i).getNbTir();
			tab[1] += zones.get(i).getBut();
		}
		tab[1] = tab[0] - tab[1];
		return tab;
	}
	
	public List<TirParZone> listerTirParZone() {
		return em.createNamedQuery("selectionToutTirParZone").getResultList(); 
	}
	
}