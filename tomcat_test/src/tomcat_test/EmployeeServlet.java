package tomcat_test;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/")
public class EmployeeServlet extends HttpServlet{
	private EmployeeDAO employeeDAO;

	public void init() {
		employeeDAO = new EmployeeDAO();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/register":
				registerUser(request, response);
				break;
			default:
				employeeList(request, response);
				break;
			}
		} catch (SQLException e) {
			throw new ServletException(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	protected void registerUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ClassNotFoundException{
		String userName = request.getParameter("name");
		String birthday = request.getParameter("birthday");
		int department_id = 4;//Integer.parseInt(request.getParameter("department_id"));
		String memo = request.getParameter("memo");

		Employee employee = new Employee(userName, birthday, department_id, memo);
		employeeDAO.registerNewEmployee(employee);

		response.sendRedirect(request.getContextPath() + "/");
	}

	protected void employeeList(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, ServletException, IOException {
		ArrayList<Employee> employeeList = employeeDAO.getAllEmployee();
		request.setAttribute("employeeList", employeeList);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("Home.jsp");
		requestDispatcher.forward(request, response);
	}
}
