package test;

import dao.RegisterDAO;
import model.User;

public class RegisterDaoTest {
	public static void main(String[] args) {
		  User user = new User();
		  int test = 2;
		  String name = "Test";
		  String pass = "Test";
		  int quantitiy = 1;
		  user.setId(test);
		  user.setName(name);
		  user.setPassword(pass);
		  user.setOutputTimes(quantitiy);
		  RegisterDAO register_dao= new RegisterDAO();
		  register_dao.Register(user);
	  }  
}
