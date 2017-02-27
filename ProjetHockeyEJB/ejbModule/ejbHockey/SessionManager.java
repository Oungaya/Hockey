package ejbHockey;

import java.security.SecureRandom;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class SessionManager implements SessionManagerRemote {

	public SessionManager() {}
	@PersistenceContext
	EntityManager em;
	
	public void ajouterToken(String token){
		
		//temps de connexion (en secondes)
		int connexionTime = 1200000; //20 minutes
		
	    //generate timestamps
	    Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    
	    //temps de validité
	    double validity = timestamp.getTime() + connexionTime;
	    
		Session session = new Session(token, validity);
		em.persist(session);
	}
	public Boolean checkToken(String token)
	{
		//timestamps actuel 
		 Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		 double ActualTime = timestamp.getTime();
		
		//check token par rapport au timestamps actuel
		List<Session> sessions = em.createNamedQuery("checkToken")
		.setParameter("paramToken", token)
		.setParameter("paramValidity", ActualTime)
		.getResultList();
		if(sessions.isEmpty()){
			return false;
		}else{
			//update validity
			return true;
		}
	}
	public void destroyToken(String token)
	{
		List <Session> list = em.createNamedQuery("findSessionWithToken")
				.setParameter("paramToken", token)
				.getResultList();
		
		Session session = list.get(0);
		System.out.println("Token qui va être supprimé : " + session.getToken());
		em.remove(session);
	}
}
