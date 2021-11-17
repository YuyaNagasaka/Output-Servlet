package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IndexDAO;
import model.Output;
import model.User;
@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public IndexServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  HttpSession session = request.getSession();
	  User user = (User)session.getAttribute("user");
	  IndexDAO index = new IndexDAO();
	  List<Output> outputList = index.Index(user);
	  request.setAttribute("list", outputList);
	  RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
	  dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		  User user = (User)session.getAttribute("user");
		  IndexDAO index = new IndexDAO();
		  List<Output> outputList = index.Index(user);
		  request.setAttribute("list", outputList);
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/Index.jsp");
		  dispatcher.forward(request, response);

		}
	}
