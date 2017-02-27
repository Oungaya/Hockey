package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
@Remote

public interface TirParZoneManagerRemote {

	public TirParZone ajouterTirParZone(TirParZone tirParZone);
	public List<TirParZone> listerTirParZone();
	public void ajouterTirParZone(ZoneTir zonetir, ZoneArret zonearret, Gardien gardien, Match match, int result);
	public int[] nbTirParZoneArret(int idZone, int idGardien, int idMatch);
	public int[] nbTirParZoneTir(int idZone, int idGardien, int idMatch);
	public int[] nbTirParZoneTirAll(int idZone, int idGardien);
	public int[] nbTirParZoneArretAll(int idZone, int idGardien);


}