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
        User user = (User)session.getAttribute("user");
        
        int user_id =0;
        
        if(user != null) {
          user_id = user.getId();
        }
        
        if(!title.isEmpty() && !description.isEmpty() && !keyword.isEmpty()) {
          
          if(title.length()<=20 ){
            output.setTitle(title);
          }else {
            request.setAttribute("createTitleErrorMessage","タイトルの文字数が多すぎます。20文字以内に修正してください。");
            RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
            dispatcher.forward(request,response); 
          }
          
          if(description.length()<=50 ){
            output.setDescription(description);
          }else {
              request.setAttribute("createDescriptionErrorMessage","説明の文字数が多すぎます。50文字以内に修正してください。");
              RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
              dispatcher.forward(request,response); 
            }
          
          if(keyword.length()<10 ){
            output.setKeyword(keyword);
          }else {
              request.setAttribute("createKeywordErrorMessage","キーワードの文字数が多すぎます。10文字以内に修正してください。");
              RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
              dispatcher.forward(request,response); 
            }
          
          if(user_id != 0){
          output.setUserId(user_id);
          }
          
          CreateDAO create = new CreateDAO();
          create.Create(output);
          request.setAttribute("createSuccessMessage","投稿に成功しました");
          RequestDispatcher dispatcher = request.getRequestDispatcher("/IndexServlet");
          dispatcher.forward(request,response);
        }else{
          request.setAttribute("createErrorMessage","空白の部分があります。すべての項目を入力してください。");
          RequestDispatcher dispatcher = request.getRequestDispatcher("/Create.jsp");
          dispatcher.forward(request,response);
        }
        
	}

}
