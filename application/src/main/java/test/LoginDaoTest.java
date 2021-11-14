package test;

import dao.LoginDAO;
import model.User;

public class LoginDaoTest {
  public static void main(String[] args) {
	  LoginDAO login_dao= new LoginDAO();
	  User user = new User();
	  String name = "Test";
	  String pass = "Test";
	  user.setName(name);
	  user.setPassword(pass);
	  login_dao.Login(user);
	  name = "dummy";
	  pass = "dummy";
	  user.setName(name);
	  user.setPassword(pass);
	  login_dao.Login(user);
  }  
}
