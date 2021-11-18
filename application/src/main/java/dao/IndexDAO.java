package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Output;
import model.User;

public class IndexDAO {
  Connection conn = null; //DBへの接続や切断を行う	
  String url = "jdbc:mysql://test.cnrljbqlg5co.ap-northeast-1.rds.amazonaws.com/application";
  String user = "root";
  String password = "nagasaka0928"; 
  List<Output> outputList = new ArrayList<Output>();
  public List<Output> Index(User info) {
	    try {
	      Class.forName("com.mysql.jdbc.Driver");//使用するJDBCドライバの指定
	      conn = DriverManager.getConnection(url,user,password);//データベース接続
	      String sql = "Select * From output where user_id = ?";
	      PreparedStatement statement = conn.prepareStatement(sql);
	      statement.setInt(1,info.getId());
	      ResultSet result = statement.executeQuery();
	      
	      while (result.next()) {
	    	    int id = result.getInt("id");
	    	    String title = result.getString("title");
	    	    String description = result.getString("description");
	    	    String keyword = result.getString("keyword");
	    	    Output output = new Output();
	    	    output.setId(id);
	    	    output.setTitle(title);
	    	    output.setDescription(description);
	    	    output.setKeyword(keyword);
	    	    outputList.add(output);
	    	  }return outputList;
	      
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