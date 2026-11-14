import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><link rel='stylesheet' href='style.css'></head><body>");
        out.println("<div class='box'><h2>Hello Servlet</h2>");
        out.println("<p class='result'>This page was written by a Java class.</p>");
        out.println("<a href='index.html'>Back</a></div>");
        out.println("</body></html>");
    }
}