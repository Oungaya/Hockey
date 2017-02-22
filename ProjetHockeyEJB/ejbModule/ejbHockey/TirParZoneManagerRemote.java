package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
@Remote

public interface TirParZoneManagerRemote {

	public TirParZone ajouterTirParZone(TirParZone tirParZone);
	public List<TirParZone> listerTirParZone();
	public void ajouterTirParZone(ZoneTir zonetir, ZoneArret zonearret, Gardien gardien, Match match, int result);
	
}