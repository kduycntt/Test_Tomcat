package tomcat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployeeDAO {
	private static String DB_URL = "jdbc:mysql://localhost:3306/user?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USER_NAME = "root";
    private static String PASSWORD = "pa$$9680";

    private static String SELECT_ALL_USER = "SELECT * FROM user_master";
//    private static String SELECT_ALL_USER_WITH_DEPARTMENT_NAME = "SELECT a.id, a.name, a.birthday, b.name, a.memo FROM user_master as a, department_master as b WHERE a.department_id = b.id";
	private static String INSERT_USER = "INSERT INTO user_master" +
			"(name, birthday, department_id, memo) VALUES "+
			" (?,?,?,?) ";
	private static String DELETE_USER = "DELTE FROM user_master WHERE id = ?";
	private static String UPDATE_USER = "UPDATE FROM user_master WHERE id = ?";

	public EmployeeDAO() {};

	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public ArrayList<Employee> getAllEmployee() throws ClassNotFoundException {
		ArrayList <Employee> employee = new ArrayList <Employee> ();
		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);) {
			ResultSet getResult = preparedStatement.executeQuery();

			while(getResult.next()) {
				int userID = getResult.getInt("id");
				String userName = getResult.getString("name");
				String birthday = getResult.getString("birthday");
				int department_id = getResult.getInt("department_id");
				String memo = getResult.getString("memo");
				employee.add(new Employee(userID, userName, birthday, department_id, memo));
				System.out.println(userName);
			}
			preparedStatement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	public void registerNewEmployee(Employee employee) throws ClassNotFoundException {

		try(Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER);) {

			preparedStatement.setString(1, employee.getUserName());
			preparedStatement.setString(2, employee.getBirthday());
			preparedStatement.setLong(3, 4);
			preparedStatement.setString(4, employee.getMemo());

			preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				}
			}
	}

	public void deleteEmployee(long userID) throws ClassNotFoundException {

		try(Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);)  {
			preparedStatement.setLong(0, userID);

			preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEmployee(Employee employee) throws ClassNotFoundException {
		try(Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);) {
			preparedStatement.setInt(0, employee.getUserid());
			preparedStatement.setString(1, employee.getUserName());
			preparedStatement.setString(2, employee.getBirthday());
			preparedStatement.setInt(3, employee.getDepartment_id());
			preparedStatement.setString(4, employee.getMemo());

			preparedStatement.executeUpdate();

			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
