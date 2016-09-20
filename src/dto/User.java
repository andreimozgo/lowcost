package dto;

public class User extends Entity {

	private String login;
	private String password;
	private String userRole;

	public User(){

	}

	public User(String login, String password){

		this.login = login;
		this.password = password;

	}

	public String getLogin(){
		return login;
	}
	
	public String getPassword(){
		return password;
	}
	
	public String getUserRole(){
		return userRole;
	}
}
