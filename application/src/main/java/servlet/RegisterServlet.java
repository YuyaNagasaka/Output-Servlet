package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import model.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
	  dispatcher.forward(request,response);
			}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  
	  String name = request.getParameter("name");
	  String password = request.getParameter("password");
	  User user = new User();
	  
	  if(!name.isEmpty() && !password.isEmpty()){
	    user.setName(name);
	    user.setPassword(password);
	    RegisterDAO register = new RegisterDAO();
	    User result = register.Register(user);
	    HttpSession session = request.getSession();
    	session.setAttribute("user",result);
	    
    	request.setAttribute("registerSuccessMessage","会員登録に成功しました");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
		dispatcher.forward(request,response);
	  }else {
		request.setAttribute("registerErrorMessage","空白の部分があります。すべての項目を入力してください。");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
	    dispatcher.forward(request, response);
	    }
	}
}