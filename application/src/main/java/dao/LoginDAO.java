package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class LoginDAO {
  
  User user_info = new User();
  Connection conn = null; //DBへの接続や切断を行う	
  
  String url = "jdbc:mysql://localhost/application";
  String user = "root";
  String password = "Nagasaka0928";

  public User Login(User info) {
    try {
      Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
      conn = DriverManager.getConnection(url,user,password);//データベース接続
      
      String sql = "SELECT * FROM user where name=? and password = ?";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1,info.getName());
      statement.setString(2,info.getPassword());
      ResultSet result = statement.executeQuery();
      
      if (result.next()){
      user_info.setName(result.getString("name"));
      user_info.setPassword(result.getString("password"));
      user_info.setId(result.getInt("id"));
      return user_info;
      }else {
    	  return null;
      }
    }
    
    catch(SQLException e) {
    	e.printStackTrace();
    	return null;
    }
    catch(ClassNotFoundException e) {
    	e.printStackTrace();
    	return null;
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
