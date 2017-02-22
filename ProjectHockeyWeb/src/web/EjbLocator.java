package web;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import ejbHockey.GardienManagerRemote;
import ejbHockey.MatchManagerRemote;
import ejbHockey.TirParZoneManagerRemote;
import ejbHockey.UtilisateurManagerRemote;
import ejbHockey.ZoneArretManagerRemote;
import ejbHockey.ZoneTirManagerRemote;



public class EjbLocator {
	private static Context ctx;
	private static EjbLocator instance = new EjbLocator();
	private EjbLocator() {
	}
	public static EjbLocator getLocator() {
		return instance;
	}

	private <T> T getEjb(Class<T> ejbClass, String beanName) {
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			final String appName = "ProjetHockeyEAR";
			final String moduleName = "ProjetHockeyEJB";

			return (T) context.lookup("java:global/" + appName + "/" + moduleName + "/" + beanName + "!" + ejbClass.getName());
		} catch (NamingException e) {
			return null;
		}
	}	
	public UtilisateurManagerRemote getUtilisateurManager() {
		return getEjb(UtilisateurManagerRemote.class, "UtilisateurManager");
	}
	public GardienManagerRemote getGardienManager(){
		return getEjb(GardienManagerRemote.class, "GardienManager");
	}
	public TirParZoneManagerRemote getTirParZoneManagerRemote(){
		return getEjb(TirParZoneManagerRemote.class, "TirParZoneManager");
	}
	public MatchManagerRemote getMatchManager(){
		return getEjb(MatchManagerRemote.class, "MatchManager");

	}
	public ZoneTirManagerRemote getZoneTirManagerRemote(){
		return getEjb(ZoneTirManagerRemote.class, "ZoneTirManagerRemote");
	}
	public ZoneArretManagerRemote getZoneArretManagerRemote(){
		return getEjb(ZoneArretManagerRemote.class, "ZoneArretManagerRemote");
	}

	}

