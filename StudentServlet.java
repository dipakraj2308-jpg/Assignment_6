import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {

    private static final String URL  = "jdbc:mysql://localhost:3306/lab5_db";
    private static final String USER = "root";
    private static final String PASS = "";

    // show all students
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<String[]> rows = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 Statement st = con.createStatement();
                 ResultSet rs = st.executeQuery("SELECT id, name, gender, dept, marks FROM `2024CSB082`")) {
                while (rs.next()) {
                    rows.add(new String[] {
                        rs.getString("id"), rs.getString("name"), rs.getString("gender"),
                        rs.getString("dept"), rs.getString("marks")
                    });
                }
            }
        } catch (Exception e) {
            request.setAttribute("error", "Database error: " + e.getMessage());
        }
        request.setAttribute("rows", rows);
        request.getRequestDispatcher("students.jsp").forward(request, response);
    }

    // add a student
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection con = DriverManager.getConnection(URL, USER, PASS);
                 PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO `2024CSB082` (name, gender, dept, marks) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, request.getParameter("name"));
                ps.setString(2, request.getParameter("gender"));
                ps.setString(3, request.getParameter("dept"));
                ps.setInt(4, Integer.parseInt(request.getParameter("marks")));
                ps.executeUpdate();
            }
        } catch (Exception e) {
            // ignored for simplicity; the list below will simply not show a new row
        }
        response.sendRedirect("students");   // reload the list with a fresh GET
    }
}