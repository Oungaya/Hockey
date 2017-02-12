package ejbHockey;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface GardienManagerRemote {
	public Gardien rechercherGadien(int id);
	public List<Gardien> listerGardiens();
}
