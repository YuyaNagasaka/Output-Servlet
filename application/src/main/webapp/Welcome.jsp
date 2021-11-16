<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String logoutMessage = (String)request.getAttribute("logoutMessage");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>トップ画面</title>
  </head>
  <body>
    <nav id="nav">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Welcome.jsp">トップ</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Register.jsp">会員登録</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Login.jsp">ログイン</a></li>
     </ul>
    </nav>
    <h1>Output of Habits ～ 投稿型アウトプットアプリ ～</h1>
    <% if(logoutMessage != null){%>
      <p style = "color:lime;"><%= logoutMessage %></p>
    <%}%>
    <form action = "/application/RegisterServlet" method="get">
      <input type = submit value = "会員登録"><br>
    </form>
    <form action = "/application/LoginServlet" method="get">
      <input type = submit value = "ログイン"><br>
    </form>
  </body>
</html>