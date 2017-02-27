package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbHockey.Gardien;
import ejbHockey.Match;
import ejbHockey.TirParZone;
import ejbHockey.TirParZoneManagerRemote;
import ejbHockey.ZoneArret;
import ejbHockey.ZoneTir;

/**
 * Servlet implementation class AddTirParZoneExecuteServlet
 */
@WebServlet("/AddTirParZoneExecuteServlet")
public class AddTirParZoneExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTirParZoneExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TirParZone tirZone = new TirParZone();
		/*tirZone.setGardien(new Gardien(Integer.parseInt(request.getParameter("tirzone.idGardien"))));
		tirZone.setMatch(new Match(Integer.parseInt(request.getParameter("tirzone.idMatch"))));
		tirZone.setZoneTir(new ZoneTir(Integer.parseInt(request.getParameter("tirzone.idZonetir"))));
		tirZone.setZoneArret(new ZoneArret(Integer.parseInt(request.getParameter("tirzone.idZonearret"))));
		TirParZoneManagerRemote managerRemote = EjbLocator.getLocator().getTirParZoneManager();
		TirParZone newTirParZone = managerRemote.ajouterTirParZone(tirZone);
		/*RequestDispatcher rd = null;
		if(newTirParZone.getId() > 0) {
			rd = request.getRequestDispatcher("/WEB-INF/jsps/contactAdded.jsp");
		}
		else {
			rd = request.getRequestDispatcher("/WEB-INF/jsps/contactNotAdded.jsp");
		}
		rd.forward(request, response);
		*/
		//SELECT sum(nbTir), sum(but) FROM tirparzone where zonetir_id = 1
	}

}
