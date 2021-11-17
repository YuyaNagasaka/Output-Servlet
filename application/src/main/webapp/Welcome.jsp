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
    <nav id="nav">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Welcome.jsp">トップ</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Register.jsp">会員登録</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Login.jsp">ログイン</a></li>
     </ul>
    </nav>
    <h1 class ="mt-5 ml-5">Output of Habits ～ 投稿型アウトプットアプリ ～</h1>
    <% if(logoutMessage != null){%>
      <div class="alert alert-success" role="alert"> 
         <%= logoutMessage %>
      </div>
    <%}%>
    <form action = "/application/RegisterServlet" method="get">
      <button class="btn btn-success btn-lg w-50 mt-5 ml-5" type="submit" >会員登録</button>
    </form>
    <form action = "/application/LoginServlet" method="get">
      <button class="btn btn-info btn-lg w-50 mt-5 ml-5" type="submit">ログイン</button><br>
    </form>
  </body>
</html>