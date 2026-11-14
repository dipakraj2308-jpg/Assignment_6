<%@ page contentType="text/html;charset=UTF-8" import="java.util.*" %>
<%! String esc(String s) { return s == null ? "" : s.replace("<", "&lt;").replace(">", "&gt;"); } %>
<% List<String[]> rows = (List<String[]>) request.getAttribute("rows");
   String error = (String) request.getAttribute("error"); %>
<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
  <div class="box">
    <h2>Add a Student</h2>
    <form action="students" method="post">
      Name: <input type="text" name="name" required><br>
      Marks: <input type="number" name="marks" min="0" max="100" required><br>
      Gender:
      <input type="radio" name="gender" value="Male" checked> Male
      <input type="radio" name="gender" value="Female"> Female<br>
      Department:
      <select name="dept">
        <option>CSE</option><option>ECE</option><option>ME</option><option>IT</option>
      </select><br>
      <button type="submit">Add</button>
    </form>
  </div>

  <div class="box" style="width:700px">
    <h2>Student Records</h2>
    <% if (error != null) { %>
      <p class="error"><%= error %></p>
    <% } else { %>
      <table>
        <tr><th>ID</th><th>Name</th><th>Gender</th><th>Dept</th><th>Marks</th></tr>
        <% for (String[] r : rows) { %>
          <tr><td><%= r[0] %></td><td><%= esc(r[1]) %></td><td><%= esc(r[2]) %></td>
              <td><%= esc(r[3]) %></td><td><%= r[4] %></td></tr>
        <% } %>
      </table>
    <% } %>
    <br><a href="index.html">Back</a>
  </div>
</body>
</html>