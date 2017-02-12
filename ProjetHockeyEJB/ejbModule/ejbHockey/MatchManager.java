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
	public Match rechercherMatch(int id) {
		return em.find(Match.class, id);
	}
	public List<Match> listerMatchs() {
		return em.createNamedQuery("selectionToutMatch").getResultList(); 
	}
}