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
import ejbHockey.GardienManagerRemote;
import ejbHockey.Match;
import ejbHockey.MatchManagerRemote;
import ejbHockey.TirParZone;
import ejbHockey.TirParZoneManagerRemote;
import ejbHockey.Utilisateur;
import ejbHockey.UtilisateurManagerRemote;
import ejbHockey.ZoneArret;
import ejbHockey.ZoneArretManagerRemote;
import ejbHockey.ZoneTir;
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
		int zone_arret_id = Integer.parseInt(request.getParameter("zone_tir_id"));
		int zone_shoot_id = Integer.parseInt(request.getParameter("zone_shoot_id"));
		int gardien_id =  Integer.parseInt(request.getParameter("gardien_id"));
		int resultat_id = Integer.parseInt(request.getParameter("resultat_id"));
		int match_id = 1;
		
		System.out.println("param envoyés : zone_arret : " + zone_arret_id + " zone_tir : "+ zone_shoot_id +" gardien_id " + gardien_id + "resultat_id : " + resultat_id +" match_id : " + match_id);
		
		TirParZoneManagerRemote TirParZoneManager = EjbLocator.getLocator().getTirParZoneManagerRemote();
		
		TirParZoneManager.ajouterTirParZone(zone_shoot_id, zone_arret_id, gardien_id, match_id);


		
		
		
	}

}
