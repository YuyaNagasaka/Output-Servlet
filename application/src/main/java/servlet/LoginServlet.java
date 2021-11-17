package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.LoginDAO;
import model.User;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	  
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
	  dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  User user = new User();
	  String name = request.getParameter("name");
	  String password = request.getParameter("password");
	  if(!name.isEmpty() && !password.isEmpty()){
	    user.setName(name);
	    user.setPassword(password);
	    LoginDAO login =new  LoginDAO();
	    
	    User result = login.Login(user);
	    if(result != null) {
	    	HttpSession session = request.getSession();
	    	session.setAttribute("user",result);
	    	request.setAttribute("loginSuccessMessage","ログインに成功しました");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
	        dispatcher.forward(request, response);
	    }else {
	    	request.setAttribute("loginErrorMessage1","入力された情報は見つかりません。正しく入力してください。");
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
		    dispatcher.forward(request, response); 
	  }
	}else {
		request.setAttribute("loginErrorMessage2","空白の部分があります。すべての項目を入力してください。");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
		dispatcher.forward(request, response);
		}
	}

}
