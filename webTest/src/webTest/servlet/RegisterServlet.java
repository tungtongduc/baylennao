package webTest.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webTest.dataConnection.DBBaylennaoDAO;
import webTest.entity.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final DBBaylennaoDAO db;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegisterServlet() {
		super();
		db = new DBBaylennaoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String info = request.getParameter("info");
		if (info != null) {
			if (info.equals("password")) {
				request.setAttribute("error", "retype password not correct!!!");
			}
			if (info.equals("username")) {
				request.setAttribute("error", "Username existed ");
			}
			if (info.equals("success")) {
				request.setAttribute("msg", "sign up succesful!!!");
			}
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(
				"/WEB-INF/view/register.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		User user = db.getUserDAO().getUserByUsername(username);

		if (!password.equals(repassword)) {
			response.sendRedirect("register?info=password");
		} else if (user != null) {
			response.sendRedirect("register?info=username");
		} else {
			User newUser = new User();
			newUser.setUsername(username);
			newUser.setPassword(password);
			db.getUserDAO().createUser(newUser);
			response.sendRedirect("register?info=success");
		}
	}

}
