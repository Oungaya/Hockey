package ejbHockey;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface ZoneTirManagerRemote {
	public ZoneTir rechercherZoneTir(int id);
	public List<ZoneTir> listerZoneTir();
}