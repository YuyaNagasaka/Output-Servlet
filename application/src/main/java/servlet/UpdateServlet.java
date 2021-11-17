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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  Output output = new Output();
	  request.setCharacterEncoding("UTF-8");
      int id = Integer.parseInt(request.getParameter("id"));
	  String title = request.getParameter("title");
	  String description = request.getParameter("description");
	  String keyword = request.getParameter("keyword");
      output.setId(id);
	  output.setTitle(title);
	  output.setDescription(description);
	  output.setKeyword(keyword);
	  UpdateDAO update = new UpdateDAO();
	  update.Update(output);
	  request.setAttribute("updateSuccessMessage","投稿を更新しました");
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/IndexServlet");
	  dispatcher.forward(request,response);
	 

	}

}
