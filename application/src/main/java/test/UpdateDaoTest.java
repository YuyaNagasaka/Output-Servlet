package test;

import dao.UpdateDAO;
import model.Output;


public class UpdateDaoTest {
  public static void main(String[] args) {
    Output output = new Output();
    int id = 2;
    String title  = "Update";
    String description = "Update";
    String keyword = "Update";
    output.setId(id);
    output.setTitle(title);
    output.setDescription(description);
    output.setKeyword(keyword);
    UpdateDAO update_dao= new UpdateDAO();
    update_dao.Update(output);
	  }  
}
