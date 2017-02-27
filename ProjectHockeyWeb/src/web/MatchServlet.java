package web;

import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbHockey.GardienManagerRemote;
import ejbHockey.MatchManagerRemote;
import ejbHockey.SessionManagerRemote;

/**
 * Servlet implementation class MatchServlet
 */
@WebServlet("/MatchServlet")
public class MatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
			System.out.println("gardien");
			String tokenSession = request.getParameter("token");
			System.out.println("token applet :"  + tokenSession);
			
			SessionManagerRemote sessionManager = EjbLocator.getLocator().getSessionManager();
			
			if (sessionManager.checkToken(tokenSession)){
				System.out.println("token valide ");

				MatchManagerRemote matchManagerRemote = EjbLocator.getLocator().getMatchManager();
				ObjectOutputStream sortie=new ObjectOutputStream(response.getOutputStream());
				sortie.writeObject(matchManagerRemote.listerMatchs());
			}else{
				System.out.println("token invalide");
			}
	}


}
