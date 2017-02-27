package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.Remote;
@Remote

public interface SessionManagerRemote {
	public void ajouterToken(String token);
	public Boolean checkToken(String token);
	public void destroyToken(String token);
	
}