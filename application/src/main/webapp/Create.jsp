<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%String createErrorMessage = (String) request.getAttribute("createErrorMessage");
  String loginSuccessMessage = (String) request.getAttribute("loginSuccessMessage");
  String registerSuccessMessage = (String) request.getAttribute("registerSuccessMessage");
  
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>新規投稿画面</title>
    <link href="Footer.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    
    <nav class="navbar navbar-dark bg-dark">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li class = mr-3><a href="/application/Create.jsp" class = "text-white">新規投稿</a></li>
        <li class ="mr-3"><a href="/application/IndexServlet" class = "text-white">投稿一覧</a></li>
        <li class ="mr-3"><a href="/application/LogoutServlet" class = "text-white">ログアウト</a></li>
      </ul>
    </nav>
     
    
    <% if(createErrorMessage != null){%>
      <div class="alert alert-danger" role="alert">
        <div class = "ml-4"><%= createErrorMessage %></div>
      </div>
    <%}%>
    
    <% if(loginSuccessMessage != null){%>
      <div class="alert alert-success" role="alert">
        <div class = "ml-4"><%= loginSuccessMessage %></div>
      </div>
    <%}%>
    
    <% if(registerSuccessMessage != null){%>
      <div class="alert alert-success" role="alert">
        <div class = "ml-4"><%= registerSuccessMessage %></div>
      </div>
    <%}%>
    <h1  class = "mt-5 ml-5">投稿画面</h1>
    
    <form action = "/application/CreateServlet" method="Post">
      <div class = "mt-3 ml-5">タイトル　　<input type = "text" name="title"></div>
      <div class = "mt-3 ml-5">説明　　　　<input type = "text" name = "description"></div>
      <div class = "mt-3 ml-5">キーワード　<input type = "text" name = "keyword"></div>
      <button class="btn btn-success btn-lg mt-3 ml-5" type="submit">新規投稿</button>
    </form>
    <footer class="footer">
        <div class="text-white mt-3 ml-5">copyright(c)2021 Yuya Nagasaka</div>
    </footer>
  </body>
</html>