<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String loginErrorMessage1 = (String)request.getAttribute("loginErrorMessage1");
   String loginErrorMessage2 = (String)request.getAttribute("loginErrorMessage2");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>ログイン画面</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <nav id="nav">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Welcome.jsp">トップ</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Register.jsp">会員登録</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Login.jsp">ログイン</a></li>
     </ul>
    </nav>
    <h1 class = "mt-5 ml-5">ログイン</h1>
    <% if(loginErrorMessage1 != null){%>
      <div class="alert alert-danger" role="alert">
        <%= loginErrorMessage1 %>
      </div>
    <%}%>
    <% if(loginErrorMessage2 != null){%>
      <div class="alert alert-danger" role="alert">
        <%= loginErrorMessage2 %>
      </div>
    <%}%>
    <form action = "/application/LoginServlet" method="post">
      <div class = "mt-3 ml-5">ユーザー名　<input type = "text" name="name"></div>
      <div class = "mt-3 ml-5">パスワード　<input type = "password" name = "password"></div>
      <button class="btn btn-info btn-lg mt-3 ml-5" type="submit">ログイン</button>
    </form>
  </body>
</html>