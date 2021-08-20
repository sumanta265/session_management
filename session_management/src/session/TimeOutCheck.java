package session;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/check")
public class TimeOutCheck extends HttpServlet {
public void doGet(HttpServletRequest request, HttpServletResponse response)
throws IOException, ServletException {
PrintWriter out = response.getWriter();
response.setContentType("text/html");
String name = null;
HttpSession session = request.getSession(false);
if (session != null) {
name = (String) session.getAttribute("loggedUser");
out.println("<center><h1>");
out.println("Logged User is - ");
out.println(name);
out.println("</h1></center>");
} else {
out.println("<center><h1>");
out.println("Session Session Time Out");
out.println("</h1></center>");
}
}


}