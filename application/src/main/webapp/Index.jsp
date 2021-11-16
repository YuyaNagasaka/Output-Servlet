<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% String createSuccessMessage =(String)request.getAttribute("createSuccessMessage");%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>投稿一覧画面</title>
  </head>
  <body>
    <nav id="nav">
     <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Create.jsp">新規投稿</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Index.jsp">投稿一覧</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Welcome.jsp">ログアウト</a></li>
     </ul>
    </nav>
    <% if(createSuccessMessage != null){%>
      <p style = "color:lime;"><%= createSuccessMessage %></p>
    <%}%>
  </body>
</html>