<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <h1>投稿画面</h1>
    <form action = "/CreateServlet" method="Post">
      タイトル　　<input type = "text" name="text"><br>
      説明　　　　<input type = "text" name = "password"><br>
      キーワード　<input type = "text" name = "keyword"><br>
      <input type = submit value = "新規投稿">
    </form>
  </body>
</html>