package test;

import dao.RegisterDAO;
import model.User;

public class RegisterDaoTest {
	public static void main(String[] args) {
		  User user = new User();
		  String name = "Test";
		  String pass = "Test";
		  user.setName(name);
		  user.setPassword(pass);
		  RegisterDAO register_dao= new RegisterDAO();
		  register_dao.Register(user);
	  }  
}
