package session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/timeout")
public class sessionTimeOut extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 3904809970499583233L;

public void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException, ServletException {

	PrintWriter out = response.getWriter();
    response.setContentType("text/html");
    String name = request.getParameter("userName");
    String pass = request.getParameter("password");
    if (pass.equalsIgnoreCase("admin@123")) {
        out.println("<Center><h3>");
        out.println("Creating A New Session...........");
        out.println("</h3></Center>");
         HttpSession session = request.getSession(true);

//Setting Session Inactive Time Out
session.setMaxInactiveInterval(5);

session.setAttribute("loggedUser", name);
out.println("<Center><h3>");
out.println("Session Created");
out.println("<br>Session Id - ");
out.println(session.getId());
out.println("<a href=\"http://localhost:8383/session_management/check\">Check Time Out</a>");
out.println("</h3></Center>");
} else {
out.println("<h1>");
out.println("Please enter correct password");
out.println("<h1>");
}
}


}