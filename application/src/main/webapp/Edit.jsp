<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>編集画面</title>
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
    <h1  class = "mt-5 ml-5">投稿編集画面</h1>
    <form action = "/application/UpdateServlet" method="Post">
      <input type="hidden" name="id" value = "${output.id}">
      <div class = "mt-3 ml-5">タイトル　　<input type = "text" name="title" value = "${output.title}"></div>
      <div class = "mt-3 ml-5">説明　　　　<input type = "text" name = "description" value = "${output.description}"></div>
      <div class = "mt-3 ml-5">キーワード　<input type = "text" name = "keyword" value = "${output.keyword}"></div>
      <button class="btn btn-success btn-lg mt-3 ml-5" type="submit">更新</button>
    </form>   
  </body>
</html>