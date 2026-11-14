<%@ page contentType="text/html;charset=UTF-8" import="java.util.Date" %>
<%! int square(int n) { return n * n; } %>
<html>
<head><link rel="stylesheet" href="style.css"></head>
<body>
  <div class="box">
    <h2>Hello JSP</h2>
    <p class="result">Server time: <%= new Date() %></p>

    <ul>
    <% for (int i = 1; i <= 5; i++) { %>
      <li><%= i %> squared is <%= square(i) %></li>
    <% } %>
    </ul>

    <a href="index.html">Back</a>
  </div>
</body>
</html>