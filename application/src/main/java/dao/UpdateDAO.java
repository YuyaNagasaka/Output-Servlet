package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Output;

public class UpdateDAO {
	  String url = "jdbc:mysql://localhost/application";
	  String user = "root";
	  String password = "Nagasaka0928";
	    
	  public void Update(Output info) {
	    Connection conn = null;
		  try {
		    Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
		    conn = DriverManager.getConnection(url,user,password);//データベース接続
		    System.out.println("DBとの接続成功");
		    String sql = "UPDATE output SET title = ?,description = ?,keyword = ? WHERE id = ?"; 
		    PreparedStatement statement = conn.prepareStatement(sql);//SQLの送信元にSQL文を渡す
		    //未確定のパラメータに値を代入
		    statement.setString(1,info.getTitle());
		    statement.setString(2,info.getDescription());
		    statement.setString(3,info.getKeyword());
		    statement.setInt(4,info.getId());
		    statement.executeUpdate();//SQL文の実行 追加したデータの行数が戻り値になる
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