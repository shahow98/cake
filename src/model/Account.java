package model;

public class Account {
	private String email;
	private String password;
	private String first_name;
	private String last_name;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	@Override
	public String toString() {
		return "{\"email\":\"" + email + "\", \"first_name\":\"" + first_name + "\", \"last_name\":\""
				+ last_name + "\"}";
	}
	
	
	public static void main(String[] args) {
		Account account = new Account();
		System.out.println(account);
	}
}
