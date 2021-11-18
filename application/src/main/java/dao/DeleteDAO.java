package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Output;

public class DeleteDAO {
	String url = "jdbc:mysql://test.cnrljbqlg5co.ap-northeast-1.rds.amazonaws.com/application";
	  String user = "root";
	  String password = "nagasaka0928"; 
	    
  public void Delete(Output info) {
	    Connection conn = null;
		  try {
		    Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
		    conn = DriverManager.getConnection(url,user,password);//データベース接続
		    String sql = "DELETE FROM output WHERE id= ?"; 
		    PreparedStatement statement = conn.prepareStatement(sql);//SQLの送信元にSQL文を渡す
		    //未確定のパラメータに値を代入
		    statement.setInt(1,info.getId());
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
