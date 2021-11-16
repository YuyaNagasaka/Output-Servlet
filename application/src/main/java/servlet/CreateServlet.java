package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CreateDAO;
import model.Output;
import model.User;

@WebServlet("/CreateServlet")
public class CreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
		dispatcher.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Output output = new Output();
        
		String title = request.getParameter("title");
        String description = request.getParameter("description");
        String keyword = request.getParameter("keyword");
        User register = (User)session.getAttribute("register");
        User login =(User)session.getAttribute("login");
        
        int register_id =0;
        int login_id =0;
        
        if(register != null) {
          register_id = register.getId();
        }
        
        if(login != null) {
          login_id = login.getId();
        }
        
        if(!title.isEmpty() && !description.isEmpty() && !keyword.isEmpty()) {
          output.setTitle(title);
          output.setDescription(description);
          output.setKeyword(keyword);
          if(register_id != 0){
          output.setUserId(register_id);
          }
          if(login_id!=0) {
            output.setUserId(login_id);
          }
          
          CreateDAO create = new CreateDAO();
          create.Create(output);
          request.setAttribute("createSuccessMessage","投稿に成功しました");
          RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
          dispatcher.forward(request,response);
        }else{
          request.setAttribute("createErrorMessage","空白の部分があります。すべての項目を入力してください。");
          RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
          dispatcher.forward(request,response);
        }
        
	}

}
