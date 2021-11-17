<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%String createErrorMessage = (String) request.getAttribute("createErrorMessage");
  String loginSuccessMessage = (String) request.getAttribute("loginSuccessMessage");
  String registerSuccessMessage = (String) request.getAttribute("registerSuccessMessage");
  String createSuccessMessage =(String)request.getAttribute("createSuccessMessage");
  String updateSuccessMessage =(String)request.getAttribute("updateSuccessMessage");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>新規投稿画面</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  </head>
  <body>
    <nav id="nav">
      <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Create.jsp">新規投稿</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/IndexServlet">投稿一覧</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/LogoutServlet">ログアウト</a></li>
     </ul>
    </nav>
    <h1>投稿画面</h1>
     <% if(createSuccessMessage != null){%>
       <div class="alert alert-success" role="alert">
         <%= createSuccessMessage %>
       </div>>
    <%}%>
    
    <% if(updateSuccessMessage != null){%>
      <div class="alert alert-success" role="alert">
        <%= updateSuccessMessage %>
      </div>
    <%}%>
    
    <% if(createErrorMessage != null){%>
      <div class="alert alert-danger" role="alert">
        <%= createErrorMessage %>
      </div>
    <%}%>
    
    <% if(loginSuccessMessage != null){%>
      <div class="alert alert-success" role="alert">
        <%= loginSuccessMessage %>
      </div>>
    <%}%>
    
    <% if(registerSuccessMessage != null){%>
      <div class="alert alert-success" role="alert">
        <%= registerSuccessMessage %>
      </div>>
    <%}%>
    
    <form action = "/application/CreateServlet" method="Post">
      タイトル　　<input type = "text" name="title"><br>
      説明　　　　<input type = "text" name = "description"><br>
      キーワード　<input type = "text" name = "keyword"><br>
      <input type = submit value = "新規投稿">
    </form>   
  </body>
</html>