<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String logoutMessage = (String)request.getAttribute("logoutMessage");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>トップ画面</title>
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
     <% if(logoutMessage != null){%>
      <div class="alert alert-success" role="alert"> 
         <div class = "ml-4"><%= logoutMessage %></div>
      </div>
    <%}%>
    <h1 class ="mt-5 ml-5">Servlet Application</h1>
    <h2 class ="mt-5 ml-5">制作目的　アウトプット</h2>
    <h2 class ="mt-5 ml-5">制作期間　1週間</h2>
    <h2 class ="mt-5 ml-5">主な機能　1.会員登録機能　2.CRUD機能</h2>
    <form action = "/application/RegisterServlet" method="get">
      <button class="btn btn-success btn-lg w-50 mt-5 ml-5" type="submit" >会員登録</button>
    </form>
    <form action = "/application/LoginServlet" method="get">
      <button class="btn btn-info btn-lg w-50 mt-5 ml-5" type="submit">ログイン</button><br>
    </form>
    <footer class="footer">
        <div class="text-white mt-3 ml-5">copyright(c)2021 Yuya Nagasaka</div>
    </footer>
  </body>
</html>