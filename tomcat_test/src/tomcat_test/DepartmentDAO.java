package tomcat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DepartmentDAO {
	private static String DB_URL = "jdbc:mysql://localhost:3306/employeeManagement?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static String USER_NAME = "root";
    private static String PASSWORD = "pa$$9680";

    private static String SELECT_ALL_DEPARTMENT = "SELECT * FROM department_master";

    public DepartmentDAO() {}

    public ArrayList<Department> loadDepartmentList() throws ClassNotFoundException {
    	ArrayList<Department> department = new ArrayList<Department>();

    	Class.forName("com.mysql.jdbc.Driver");
		try(Connection connection = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);

				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DEPARTMENT);) {

			ResultSet getResult = preparedStatement.executeQuery();

			while(getResult.next()) {
				int departmentID = getResult.getInt("id");
				String department_name = getResult.getString("name");
				department.add(new Department(departmentID, department_name));
			}

			preparedStatement.close();
			connection.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}

    	return department;
    }
}
