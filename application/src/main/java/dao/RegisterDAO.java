package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class RegisterDAO {
  
  User user_info = new User();
  String url = "jdbc:mysql://localhost/application";
  String user = "root";
  String password = "Nagasaka0928"; 
 
  public User Register(User info) {
    Connection conn = null;
	  try {
	    Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
	    conn = DriverManager.getConnection(url,user,password);//データベース接続
	    System.out.println("DBとの接続成功");
	    
	    String sql = "INSERT INTO user (name,password) values(?,?)"; 
	    PreparedStatement statement = conn.prepareStatement(sql);//SQLの送信元にSQL文を渡す
	    //未確定のパラメータに値を代入
	    statement.setString(1,info.getName());
	    statement.setString(2,info.getPassword());
	    statement.executeUpdate();//SQL文の実行 追加したデータの行数が戻り値になる
	    
	    String sql2 = "SELECT * FROM user where name=? and password = ?";
	    
	    statement = conn.prepareStatement(sql2);
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
	    }}
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