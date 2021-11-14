package test;

import dao.DeleteDAO;
import model.Output;

public class DeleteDaoTest {
	public static void main(String[] args) {
		  DeleteDAO delete_dao= new DeleteDAO();
		  Output output = new Output();
		  output.setId(1);
		  delete_dao.Delete(output);
	  }  
}
