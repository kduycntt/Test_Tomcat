package tomcat_test;

public class Department {
	private int id;
	private String name;


	public Department(int id, String name) {
		this.id = id;
		this.setName(name);
	}

	public Department(String name) {
		this.setName(name);
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
