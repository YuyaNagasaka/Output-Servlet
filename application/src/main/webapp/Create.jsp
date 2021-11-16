<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%String createErrorMessage = (String) request.getAttribute("createErrorMessage");
  String loginSuccessMessage = (String) request.getAttribute("loginSuccessMessage");
  String registerSuccessMessage = (String) request.getAttribute("registerSuccessMessage");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>新規投稿画面</title>
  </head>
  <body>
    <nav id="nav">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Create.jsp">新規投稿</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Index.jsp">投稿一覧</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Welcome.jsp">ログアウト</a></li>
     </ul>
    </nav>
    <h1>投稿画面</h1>
    
    <% if(createErrorMessage != null){%>
      <p style = "color:red;"><%= createErrorMessage %></p>
    <%}%>
    <% if(loginSuccessMessage != null){%>
      <p style = "color:lime;"><%= loginSuccessMessage %></p>
    <%}%>
    <% if(registerSuccessMessage != null){%>
      <p style = "color:lime;"><%= registerSuccessMessage %></p>
    <%}%>
    
    <form action = "/application/CreateServlet" method="Post">
      タイトル　　<input type = "text" name="title"><br>
      説明　　　　<input type = "text" name = "description"><br>
      キーワード　<input type = "text" name = "keyword"><br>
      <input type = submit value = "新規投稿">
    </form>   
  </body>
</html>