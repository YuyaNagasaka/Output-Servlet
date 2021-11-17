package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UpdateDAO;
import model.Output;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UpdateServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Output output = new Output();
	  request.setCharacterEncoding("UTF-8");
      int id = Integer.parseInt(request.getParameter("id"));
	  String title = request.getParameter("title");
	  String description = request.getParameter("description");
	  String keyword = request.getParameter("keyword");
	  if(!title.isEmpty() && !description.isEmpty() && !keyword.isEmpty()) {
	    output.setId(id);
		if(title.length()<=20 ){
	      output.setTitle(title);
	    }else{
	      request.setAttribute("updateTitleErrorMessage","タイトルの文字数が多すぎます。20文字以内に修正してください。");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/EditServlet");
	      dispatcher.forward(request,response); 
	    }
	    if(description.length()<=50 ){
	      output.setDescription(description);
	    }else{
	      request.setAttribute("updateDescriptionErrorMessage","説明の文字数が多すぎます。50文字以内に修正してください。");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/EditServlet");
	      dispatcher.forward(request,response); 
	    }
	    if(keyword.length()<10 ){
	      output.setKeyword(keyword);
	    }else{
	      request.setAttribute("updateKeywordErrorMessage","キーワードの文字数が多すぎます。10文字以内に修正してください。");
	      RequestDispatcher dispatcher = request.getRequestDispatcher("/EditServlet");
	      dispatcher.forward(request,response); 
	    }
	    UpdateDAO update = new UpdateDAO();
	    update.Update(output);
	    request.setAttribute("updateSuccessMessage","投稿を更新しました");
	    RequestDispatcher dispatcher = request.getRequestDispatcher("/IndexServlet");
	    dispatcher.forward(request,response);
	  }else {
		request.setAttribute("updateErrorMessage","空白の部分があります。すべての項目を入力してください。");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/EditServlet");
        dispatcher.forward(request,response);
	  }
	 

	}

}
