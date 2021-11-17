<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>編集画面</title>
  </head>
  <body>
    <nav id="nav">
     <ul style = "display: flex; list-style-type: none; text-align: center;">
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/Create.jsp">新規投稿</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/IndexServlet">投稿一覧</a></li>
        <li style ="margin-top: 10px; margin-right: 10px;"><a href="/application/LogoutServlet">ログアウト</a></li>
     </ul>
    </nav>
    <h1>投稿編集画面</h1>
    <form action = "/application/UpdateServlet" method="Post">
      <input type="hidden" name="id" value = "${output.id}">
      タイトル  <input type = "text" name="title" value = "${output.title}"><br>
      説明      <input type = "text" name = "description" value = "${output.description}"><br>
      キーワード<input type = "text" name = "keyword" value = "${output.keyword}"><br>
      <input type = submit value = "更新する">
    </form>
  </body>
</html>