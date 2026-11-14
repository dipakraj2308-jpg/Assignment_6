import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/grade")
public class GradeServlet extends HttpServlet {

    private String findGrade(int marks) {
        if (marks >= 90) return "A+";
        if (marks >= 80) return "A";
        if (marks >= 70) return "B";
        if (marks >= 60) return "C";
        if (marks >= 50) return "D";
        return "F";
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String marksText = request.getParameter("marks");

        try {
            int marks = Integer.parseInt(marksText);
            if (name == null || name.trim().equals("") || marks < 0 || marks > 100) {
                request.setAttribute("error", "Enter a name and marks between 0 and 100");
            } else {
                // escape < and > so a name cannot inject HTML
                String safeName = name.replace("<", "&lt;").replace(">", "&gt;");
                request.setAttribute("name", safeName);
                request.setAttribute("marks", marks);
                request.setAttribute("grade", findGrade(marks));
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Marks must be a number");
        }

        // hand over to the JSP to display the result
        RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
        rd.forward(request, response);
    }
}