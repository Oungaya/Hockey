package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class SaisieFormServlet
 */
@WebServlet("/SaisieFormServlet")
public class SaisieFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaisieFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd;
		GardienManagerRemote gardienManagerRemote = EjbLocator.getLocator().getGardienManager();
		request.setAttribute("listGardiens", gardienManagerRemote.listerGardiens());
			
		MatchManagerRemote matchmanagerRemote = EjbLocator.getLocator().getMatchManager();
		request.setAttribute("listMatchs", matchmanagerRemote.listerMatchs());
		

		String token = (String)request.getParameter("token");
		System.out.println("token recu : " + token);
		SessionManagerRemote sessionManager = EjbLocator.getLocator().getSessionManager();
		
		if (sessionManager.checkToken(token)){
			rd = request.getRequestDispatcher("/WEB-INF/jsps/saisie.jsp");
		}else{
			rd = request.getRequestDispatcher("/WEB-INF/jsps/auth.jsp");
		}
		rd.forward(request, response);

	}


}
