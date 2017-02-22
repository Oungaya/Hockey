package ejbHockey;

import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
@LocalBean

public class MatchManager implements MatchManagerRemote {

	public MatchManager() {}
	@PersistenceContext
	EntityManager em;
	
	public List<Match> rechercherMatch(int id) {
		return em.createNamedQuery("get_match")
				.setParameter("paramId", id)
				.getResultList();
		}
	public List<Match> listerMatchs() {
		return em.createNamedQuery("selectionToutMatch").getResultList(); 
	}
}