package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DeleteDAO;
import model.Output;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DeleteServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
	  int id = Integer.parseInt(request.getParameter("id"));
	  Output output = new Output();
	  output.setId(id);
	  DeleteDAO delete = new DeleteDAO();
	  delete.Delete(output);
	  request.setAttribute("deleteSuccessMessage","投稿が削除されました");
	  RequestDispatcher dispatchr = request.getRequestDispatcher("/IndexServlet");
	  dispatchr.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
