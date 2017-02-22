package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbHockey.Utilisateur;
import ejbHockey.UtilisateurManagerRemote;

/**
 * Servlet implementation class LoginExecuteFormServlet
 */
@WebServlet("/LoginExecuteServlet")
public class LoginExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				String name = request.getParameter("name");
				String password = request.getParameter("password");
				UtilisateurManagerRemote utilisateurManager = EjbLocator.getLocator().getUtilisateurManager();
				RequestDispatcher rd = null;
				List<Utilisateur> list = utilisateurManager.isLogged(name, password);
				if (list != null){
					if(list.size() == 0){
						rd = request.getRequestDispatcher("/WEB-INF/jsps/authfailed.jsp");
					}else{
						Utilisateur user = new Utilisateur(name, password);
						HttpSession maSession = request.getSession();
						maSession.setAttribute("auth", "true");
						rd = request.getRequestDispatcher("/WEB-INF/jsps/authsuccess.jsp");
					}
					rd.forward(request, response);

				}
	}

}
