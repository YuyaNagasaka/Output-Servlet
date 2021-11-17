<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String registerErrorMessage = (String)request.getAttribute("registerErrorMessage");%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>会員登録画面</title>
    <link href="Footer.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <nav class="navbar navbar-dark bg-dark">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li class = mr-3><a href="/application/WelcomeServlet" class = "text-white">トップ</a></li>
        <li class ="mr-3"><a href="/application/RegisterServlet" class = "text-white">会員登録</a></li>
        <li class ="mr-3"><a href="/application/LoginServlet" class = "text-white">ログイン</a></li>
      </ul>
    </nav>
    <% if(registerErrorMessage != null){%>
      <div class="alert alert-danger" role="alert">
        <div class = "ml-4"><%= registerErrorMessage %></div>
      </div>
    <%}%>
    <h1 class = "mt-5 ml-5">会員登録</h1>
    
    <form action = "/application/RegisterServlet" method="post">
      <div class = "mt-3 ml-5">ユーザー名　<input type = "text" name="name"></div>
      <div class = "mt-3 ml-5">パスワード　<input type = "password" name = "password"></div>
      <button class="btn btn-success btn-lg mt-3 ml-5" type="submit">会員登録</button>
    </form>
    <footer class="footer">
        <div class="text-white mt-3 ml-5">copyright(c)2021 Yuya Nagasaka</div>
    </footer>
  </body>
</html>