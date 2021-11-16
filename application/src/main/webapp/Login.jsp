<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String loginErrorMessage1 = (String)request.getAttribute("loginErrorMessage1");
   String loginErrorMessage2 = (String)request.getAttribute("loginErrorMessage2");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ログイン画面</title>
  </head>
  <body>
    <nav id="nav">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Welcome.jsp">トップ</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Register.jsp">会員登録</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Login.jsp">ログイン</a></li>
     </ul>
    </nav>
    <h1>ログイン</h1>
    <% if(loginErrorMessage1 != null){%>
      <p style = "color:red;"><%= loginErrorMessage1 %></p>
    <%}%>
    <% if(loginErrorMessage2 != null){%>
      <p style = "color:red;"><%= loginErrorMessage2 %></p>
    <%}%>
    <form action = "/application/LoginServlet" method="post">
      ユーザー名　<input type = "text" name="name"><br>
      パスワード　<input type = "password" name = "password"><br>
      <input type = submit value = "ログイン">
    </form>
  </body>
</html>