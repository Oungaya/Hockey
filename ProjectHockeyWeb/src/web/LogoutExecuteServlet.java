package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ejbHockey.SessionManagerRemote;

/**
 * Servlet implementation class LogoutExecuteServlet
 */
@WebServlet("/LogoutExecuteServlet")
public class LogoutExecuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogoutExecuteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;

		String token = request.getParameter("token");
		System.out.println("Servlet token reçu : " + token);
		SessionManagerRemote sessionManager = EjbLocator.getLocator().getSessionManager();
		sessionManager.destroyToken(token);
		String web = request.getParameter("web");
		if (web == null)
		{
			web="";
		}
		if (web.equals("true")){
			rd = request.getRequestDispatcher("/WEB-INF/jsps/auth.jsp");
			rd.forward(request, response);
		}


	}


}
