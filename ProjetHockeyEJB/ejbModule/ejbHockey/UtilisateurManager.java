package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
@LocalBean

public class UtilisateurManager implements UtilisateurManagerRemote {

	public UtilisateurManager() {}
	@PersistenceContext
	EntityManager em;
	public Utilisateur rechercherUtilisateur(int id) {
		return em.find(Utilisateur.class, id);
	}
	public List<Utilisateur> listerUtilisateurs() {
		return em.createNamedQuery("selectionToutUtilisateur").getResultList(); 
	}
	
}
