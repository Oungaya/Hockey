package web;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbHockey.SessionManagerRemote;
import ejbHockey.TirParZoneManagerRemote;
import ejbHockey.Utilisateur;
import ejbHockey.UtilisateurManagerRemote;

/**
 * Servlet implementation class StatsServlet
 */
@WebServlet("/StatsServletZoneTir")
public class StatsServletZoneTir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatsServletZoneTir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("stats servlet zone tir");
		String tokenSession = request.getParameter("token");
		System.out.println("token applet :"  + tokenSession);
		
		SessionManagerRemote sessionManager = EjbLocator.getLocator().getSessionManager();
		
		if (sessionManager.checkToken(tokenSession)){
			int idGardien = Integer.parseInt(request.getParameter("idGardien"));
			int idMatch = Integer.parseInt(request.getParameter("idMatch"));
			List <int[]> nbTirParZoneTir = null;
			Object[][] retour= new Object[3][7];
			TirParZoneManagerRemote TirParZoneManager = EjbLocator.getLocator().getTirParZoneManager();
			retour[0][0] = "Tir";
			retour[1][0] = "Arrêt";
			retour[2][0] = "%";
			//nombre décimales %
			DecimalFormat f = new DecimalFormat();
			f.setMaximumFractionDigits(1);
			for (int i=1; i < 7; i++){
				int[] tmp;			
				if (idMatch == 0){
					tmp = TirParZoneManager.nbTirParZoneTirAll(i, idGardien);
				}else{
					tmp = TirParZoneManager.nbTirParZoneTir(i, idGardien, idMatch);
				}
				retour[0][i] = tmp[0];
				retour[1][i] = tmp[1];
				if(tmp[0] == 0)
					retour[2][i] = 0;
				else{
					retour[2][i] = (float)tmp[1]/tmp[0] * 100;
					retour[2][i] = f.format(retour[2][i]);	
					/*String ratio = retour[2][i].toString();
					if(Float.parseFloat(ratio.replace(',','.')) < 50){
						retour[2][i] = "<html><font color='red'>" + ratio + "</font></html>";
					}
					else if(Integer.parseInt(ratio) > 50){
						retour[2][i] = "<html><font color='green'>" + ratio + "</font></html>";
					}
					else{
						retour[2][i] = ratio;
					}*/
				}
			}
			ObjectOutputStream sortie=new ObjectOutputStream(response.getOutputStream());
			sortie.writeObject(retour);
		}else{
			System.out.println("token invalide zone tir");
		}
	}

}
