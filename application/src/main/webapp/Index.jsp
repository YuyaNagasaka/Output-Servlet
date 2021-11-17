<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String deleteSuccessMessage =(String)request.getAttribute("deleteSuccessMessage");
   String createSuccessMessage =(String)request.getAttribute("createSuccessMessage");
   String updateSuccessMessage =(String)request.getAttribute("updateSuccessMessage");
%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>投稿一覧画面</title>
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
    <% if(deleteSuccessMessage != null){%>
      <div class="alert alert-danger" role="alert">
        <div class = "ml-4"><%= deleteSuccessMessage %></div>
      </div>
    <%}%>
    <% if(createSuccessMessage != null){%>
       <div class="alert alert-success" role="alert">
         <div class = "ml-4"><%= createSuccessMessage %></div>
       </div>
    <%}%>
    
    <% if(updateSuccessMessage != null){%>
      <div class="alert alert-success" role="alert">
        <div class = "ml-4"><%= updateSuccessMessage %></div>
      </div>
    <%}%>
    <h1  class = "mt-5 ml-5">投稿一覧画面</h1>
    <table class = "table mt-5 ml-5 mr-5">
      <thead class="thead-light">
      <tr >
        <th>タイトル</th>
        <th>説明</th>
        <th>関連情報</th>
        <th>削除</th>
        <th>編集</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="list" items="${list}">
      <tr>
        <td><c:out value="${list.title}"/></td>
        <td><c:out value="${list.description}"/></td>
        <td><c:out value="${list.keyword}"/></td>
        <td><a href="/application/DeleteServlet?id=${list.id}">削除</a></td>
        <td><a href="/application/EditServlet?id=${list.id}& title = ${list.title}& description = ${list.description} & keyword = ${list.keyword}">編集</a></td>
      </tr>
      </c:forEach>
      </tbody>      
    </table>
    <footer class="footer">
        <div class="text-white mt-3 ml-5">copyright(c)2021 Yuya Nagasaka</div>
    </footer>
  </body>
</html>