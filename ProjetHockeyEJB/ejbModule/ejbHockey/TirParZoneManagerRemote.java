package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
@Remote

public interface TirParZoneManagerRemote {

	public TirParZone ajouterTirParZone(TirParZone contact);
	public List<TirParZone> listerTirParZone();
	
}