package ejbHockey;

import java.util.List;
import javax.ejb.Remote;

@Remote
public interface UtilisateurManagerRemote {
	public Utilisateur rechercherUtilisateur(int id);
	public List<Utilisateur> listerUtilisateurs();
}