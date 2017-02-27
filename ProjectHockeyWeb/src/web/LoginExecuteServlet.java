package web;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.SecureRandom;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbHockey.SessionManagerRemote;
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
				String web = request.getParameter("web");
				if (web == null)
				{
					web="";
				}
				
				System.out.println("web valeur : " + web);
				//HttpSession maSession = request.getSession(true);			
				UtilisateurManagerRemote utilisateurManager = EjbLocator.getLocator().getUtilisateurManager();
				RequestDispatcher rd = null;
				List<Utilisateur> list = utilisateurManager.isLogged(name, password);
				if (list != null){
					if(list.size() == 0){
						if (web.equals("true")){
							System.out.println("if if");
							rd = request.getRequestDispatcher("/WEB-INF/jsps/authfailed.jsp");
							rd.forward(request, response);
						}else{
							System.out.println("if else");
							ObjectOutputStream sortie=new ObjectOutputStream(response.getOutputStream());
							sortie.writeObject("");
						}
					}else{
						
						//generate new token
						SessionManagerRemote sessionManager = EjbLocator.getLocator().getSessionManager();
						
						//generate token
						SecureRandom random = new SecureRandom();
					    byte bytes[] = new byte[20];
					    random.nextBytes(bytes);
					    String token = bytes.toString();
					    
					    //register token
						sessionManager.ajouterToken(token);
						
						if (web.equals("true")){
							System.out.println("else if");
							rd = request.getRequestDispatcher("/WEB-INF/jsps/authsuccess.jsp");
							Cookie myCookie = new Cookie("token", token);
							response.addCookie(myCookie);
							rd.forward(request, response);
						}else{
							System.out.println("else else");
							//sent token to applet
							ObjectOutputStream sortie=new ObjectOutputStream(response.getOutputStream());
						    sortie.writeObject(token);
						}
					}

				}
	}

}
