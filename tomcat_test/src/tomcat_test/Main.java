package tomcat_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class Main {

  public static void main(String[] argv) throws Exception {
    String driver = "com.mysql.cj.jdbc.Driver";
    String connectionURL = "jdbc:mysql://localhost:3306/user?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String user = "root";
    String password = "pa$$9680";
    String SELECT_ALL_USER = "SELECT * FROM user_master";
    Class.forName(driver);
    Connection connection = DriverManager.getConnection(connectionURL, user, password);
    PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USER);

    ResultSet getResult = preparedStatement.executeQuery();
    ArrayList <Employee> employee = new ArrayList <Employee> ();
	while(getResult.next()) {
		int userID = getResult.getInt("id");
		String userName = getResult.getString("name");
		String birthday = getResult.getString("birthday");
		int department_id = getResult.getInt("department_id");
		String memo = getResult.getString("memo");
		employee.add(new Employee(userID, userName, birthday, department_id, memo));
		System.out.println(userID);
		System.out.println(userName);
		System.out.println(birthday);
		System.out.println(department_id);
		System.out.println(memo);
	}
    if (!connection.isClosed()) {
    	connection.close();
    }
  }
}