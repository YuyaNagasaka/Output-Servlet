<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String logoutMessage = (String)request.getAttribute("logoutMessage");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>トップ画面</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <% if(logoutMessage != null){%>
      <div class="alert alert-success" role="alert"> 
         <%= logoutMessage %>
      </div>
    <%}%>
    <nav class="navbar navbar-dark bg-dark">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li class = mr-3><a href="/application/WelcomeServlet" class = "text-white">トップ</a></li>
        <li class ="mr-3"><a href="/application/RegisterServlet" class = "text-white">会員登録</a></li>
        <li class ="mr-3"><a href="/application/LoginServlet" class = "text-white">ログイン</a></li>
      </ul>
    </nav>
    <h1 class ="mt-5 ml-5">Output of Habits ～ 投稿型アウトプットアプリ ～</h1>
    
    <form action = "/application/RegisterServlet" method="get">
      <button class="btn btn-success btn-lg w-50 mt-5 ml-5" type="submit" >会員登録</button>
    </form>
    <form action = "/application/LoginServlet" method="get">
      <button class="btn btn-info btn-lg w-50 mt-5 ml-5" type="submit">ログイン</button><br>
    </form>
  </body>
</html>