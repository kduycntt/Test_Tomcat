package tomcat_test;

import java.io.Serializable;

public class Employee implements Serializable{

	private int id = 1;
	private String name;
	private String birthday;
	private int department_id;
	private String memo;

	public Employee(String name, String birthday, int department_id, String memo) {
		this.name = name;
		this.birthday = birthday;
		this.department_id = department_id;
		this.memo = memo;
	}

	public Employee(int id, String name, String birthday, int department_id, String memo) {
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.department_id = department_id;
		this.memo = memo;
	}
	public int getUserid() {
		return id;
	}
	public String getUserName() {
		return name;
	}
	public void setUserName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
