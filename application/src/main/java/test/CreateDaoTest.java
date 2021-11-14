package test;

import dao.CreateDAO;
import model.Output;

public class CreateDaoTest {
	public static void main(String[] args) {
		  Output output = new Output();
		  String title = "Test";
		  String description = "Test";
		  String keyword = "Test";
		  output.setTitle(title);
		  output.setDescription(description);
		  output.setKeyword(keyword);
		  CreateDAO create_dao= new CreateDAO();
		  create_dao.Create(output);
	  }  

}
