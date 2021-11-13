package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LoginDAO {
  public void Login() {
    Connection conn = null; //DBへの接続や切断を行う
    String url = "jdbc:mysql://localhost/application";
    String user = "root";
    String password = "Nagasaka0928";
    try {
      Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
      conn = DriverManager.getConnection
      (url,user,password);//データベース接続
      System.out.println("DBとの接続成功");
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
