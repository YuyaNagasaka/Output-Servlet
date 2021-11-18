package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Output;

public class CreateDAO {
	  String url = "jdbc:mysql://test.cnrljbqlg5co.ap-northeast-1.rds.amazonaws.com/application";
	  String user = "root";
	  String password = "nagasaka0928"; 
  Connection conn = null;
  int result;
  public int Create(Output info) {
    try {
	  Connection conn = null;
	  Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
	  conn = DriverManager.getConnection(url,user,password);//データベース接続
	  String sql = "INSERT INTO output (user_id,title,description,keyword) values(?,?,?,?)"; 
	  PreparedStatement statement = conn.prepareStatement(sql);//SQLの送信元にSQL文を渡す
	  //未確定のパラメータに値を代入
	  statement.setInt(1,info.getUserId());
	  statement.setString(2,info.getTitle());
	  statement.setString(3,info.getDescription());
	  statement.setString(4,info.getKeyword());
	  statement.executeUpdate();//SQL文の実行 追加したデータ  
	  return result;
	}
    catch(SQLException e) {
      e.printStackTrace();
      return result;
    }
    catch(ClassNotFoundException e) {
      e.printStackTrace();
      return result;
    }
	finally {
      if (conn != null){
	    try {
		  conn.close();
		}catch(SQLException e) {
		  e.printStackTrace();
		}
	  }
	}
  }
 }