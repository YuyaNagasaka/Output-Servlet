package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Output;

public class DeleteDAO {
  String url = "jdbc:mysql://localhost/application";
  String user = "root";
  String password = "Nagasaka0928";
	    
  public void Delete(Output info) {
	    Connection conn = null;
		  try {
		    Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
		    conn = DriverManager.getConnection(url,user,password);//データベース接続
		    System.out.println("DBとの接続成功");
		    String sql = "DELETE FROM application.output WHERE id= ?"; 
		    PreparedStatement statement = conn.prepareStatement(sql);//SQLの送信元にSQL文を渡す
		    //未確定のパラメータに値を代入
		    statement.setInt(1,info.getId());
		    int result = statement.executeUpdate();//SQL文の実行 追加したデータの行数が戻り値になる
		      
		      if(result != 0) {
		        System.out.println("削除成功");
		      }else {
		   	    System.out.println("削除失敗");
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
