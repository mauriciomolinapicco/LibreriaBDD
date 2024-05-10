package LibreriaBDD;

public class Usuario {
	private String user;
	private String email;
	private String pass;
	
	public Usuario() {
	}
	
	public Usuario(String user, String email, String pass){
		this.user = user;
		this.email = email;
		this.pass = pass;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String getUser() {
		return user;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public void setUser(String user) {
		this.user = user;
	}

}
