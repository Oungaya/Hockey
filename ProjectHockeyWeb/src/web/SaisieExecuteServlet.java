package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbHockey.Gardien;
import ejbHockey.GardienManager;
import ejbHockey.GardienManagerRemote;
import ejbHockey.Match;
import ejbHockey.MatchManager;
import ejbHockey.MatchManagerRemote;
import ejbHockey.TirParZone;
import ejbHockey.TirParZoneManagerRemote;
import ejbHockey.Utilisateur;
import ejbHockey.UtilisateurManagerRemote;
import ejbHockey.ZoneArret;
import ejbHockey.ZoneArretManagerRemote;
import ejbHockey.ZoneTir;
import ejbHockey.ZoneTirManager;
import ejbHockey.ZoneTirManagerRemote;

/**
 * Servlet implementation class SaisieExecuteServlet
 */
@WebServlet("/SaisieExecuteServlet")
public class SaisieExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisieExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idZoneTir = Integer.parseInt(request.getParameter("zone_shoot_id"));
		int idZoneArret = Integer.parseInt(request.getParameter("zone_tir_id"));
		int idGardien =  Integer.parseInt(request.getParameter("gardien_id"));
		int result = Integer.parseInt(request.getParameter("resultat_id"));
		int idMatch = 1;
		
		//get zonetir
		ZoneTirManagerRemote zoneTirManager = EjbLocator.getLocator().getZoneTirManager();
		ZoneTir zonetir = zoneTirManager.rechercherZoneTir(idZoneTir);
		
		//get zonearret
		ZoneArretManagerRemote zoneArretManager = EjbLocator.getLocator().getZoneArretManager();
		ZoneArret zonearret = zoneArretManager.rechercherZoneArret(idZoneArret);
		
		//getGardie
		GardienManagerRemote gardienManager = EjbLocator.getLocator().getGardienManager();
		Gardien gardien = gardienManager.rechercherGadien(idGardien);
		
		//getMatch
		MatchManagerRemote matchManager = EjbLocator.getLocator().getMatchManager();
		Match match = matchManager.rechercherMatch(idMatch);

		
		TirParZoneManagerRemote tirParZoneManager = EjbLocator.getLocator().getTirParZoneManager();
		tirParZoneManager.ajouterTirParZone( zonetir,  zonearret, gardien, match, result);


		
		
		
	}

}
