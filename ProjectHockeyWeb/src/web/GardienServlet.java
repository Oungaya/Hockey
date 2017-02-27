package web;

import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ejbHockey.GardienManagerRemote;
import ejbHockey.SessionManagerRemote;

/**
 * Servlet implementation class GardienServlet
 */
@WebServlet("/GardienServlet")
public class GardienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GardienServlet() {
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
		
			GardienManagerRemote gardienManagerRemote = EjbLocator.getLocator().getGardienManager();
			ObjectOutputStream sortie=new ObjectOutputStream(response.getOutputStream());
			sortie.writeObject(gardienManagerRemote.listerGardiens());
		}else{
			System.out.println("token invalide");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
