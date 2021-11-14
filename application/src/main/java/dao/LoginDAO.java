package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class LoginDAO {
  public void Login(User info) {
    Connection conn = null; //DBへの接続や切断を行う
    String url = "jdbc:mysql://localhost/application";
    String user = "root";
    String password = "Nagasaka0928";
    try {
      Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
      conn = DriverManager.getConnection(url,user,password);//データベース接続
      System.out.println("DBとの接続成功");
      String sql = "SELECT * FROM application.user where name=? and password = ?";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1,info.getName());
      statement.setString(2,info.getPassword());
      ResultSet result = statement.executeQuery();
      if(result.next()) {
    	  System.out.println("ログインに成功しました");
      }else {
    	  System.out.println("ログインに失敗しました");
      }
    }
    
    catch(SQLException e) {
    	e.printStackTrace();
    }
    catch(ClassNotFoundException e) {
    	e.printStackTrace();
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
