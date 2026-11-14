<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
  <div class="box">
    <h2>Result</h2>
    <% String error = (String) request.getAttribute("error");
       if (error != null) { %>
      <p class="error"><%= error %></p>
    <% } else { %>
      <p class="result">
        Name: <b><%= request.getAttribute("name") %></b><br>
        Marks: <b><%= request.getAttribute("marks") %></b><br>
        Grade: <b><%= request.getAttribute("grade") %></b>
      </p>
    <% } %>
    <a href="index.html">Back</a>
  </div>
</body>
</html>