package ejbHockey;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface MatchManagerRemote {
	public List<Match> rechercherMatch(int id);
	public List<Match> listerMatchs();
}