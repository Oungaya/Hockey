package ejbHockey;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ZoneArretManagerRemote {
	public ZoneArret rechercherZoneArret(int id);
	public List<ZoneArret> listerZoneArret();
}