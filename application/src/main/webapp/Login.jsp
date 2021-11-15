<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>
  <body>
    <h1>ログイン</h1>
    <form action = "/LoginrServlet" method="Post">
      ユーザー名　<input type = "text" name="text"><br>
      パスワード　<input type = "password" name = "password"><br>
      <input type = submit value = "ログイン">
    </form>
  </body>
</html>