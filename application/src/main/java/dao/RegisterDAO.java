package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class RegisterDAO {
	
  String url = "jdbc:mysql://localhost/application";
  String user = "root";
  String password = "Nagasaka0928";
    
  public void Register(User info) {
    Connection conn = null;
	  try {
	    Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
	    conn = DriverManager.getConnection(url,user,password);//データベース接続
	    System.out.println("DBとの接続成功");
	    String sql = "INSERT INTO user (id,name,password,output_times) values(?,?,?,?)"; 
	    PreparedStatement statement = conn.prepareStatement(sql);//SQLの送信元にSQL文を渡す
	    //未確定のパラメータに値を代入
	    statement.setInt(1,info.getId());
	    statement.setString(2,info.getName());
	    statement.setString(3, info.getPassword());
	    statement.setInt(4,info.getOutputTimes());
	    int result = statement.executeUpdate();//SQL文の実行 追加したデータの行数が戻り値になる
	      
	      if(result != 0) {
	        System.out.println("新規登録成功");
	      }else {
	   	    System.out.println("新規登録失敗");
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