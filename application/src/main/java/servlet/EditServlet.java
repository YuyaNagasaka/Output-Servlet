package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Output;

@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("UTF-8");
      int id = Integer.parseInt(request.getParameter("id"));
	  String title = request.getParameter("title");
	  String description = request.getParameter("description");
	  String keyword = request.getParameter("keyword");
	  Output output = new Output();
	  output.setId(id);
	  output.setTitle(title);
	  output.setDescription(description);
	  output.setKeyword(keyword);;
	  request.setAttribute("output",output);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/Edit.jsp");
	  dispatcher.forward(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
