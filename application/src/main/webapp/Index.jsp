<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String deleteSuccessMessage =(String)request.getAttribute("deleteSuccessMessage"); %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>投稿一覧画面</title>
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
    <% if(deleteSuccessMessage != null){%>
      <p style = "color:red;"><%= deleteSuccessMessage %></p>
    <%}%>
    <table>
      <tr>
        <th>タイトル</th>
        <th>説明</th>
        <th>関連情報</th>
        <th>削除</th>
        <th>編集</th>
      </tr>
      <c:forEach var="list" items="${list}">
      <tr>
        <td><c:out value="${list.title}"/></td>
        <td><c:out value="${list.description}"/></td>
        <td><c:out value="${list.keyword}"/></td>
        <td><a href="/application/DeleteServlet?id=${list.id}">削除</a></td>
        <td><a href="/application/EditServlet?id=${list.id}&${title=list.title}& ${description=list.description} & keyword = ${list.keyword}">編集</a></td>
      </tr>
      </c:forEach>
    </table>
  </body>
</html>