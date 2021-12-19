package org.intellect.dao;

public class DataBase {

	private String url = "jdbc:postgresql://localhost/Test";
	
	private String user = "postgres";
	
	private String passwd = "Vedha12";
	
	private String signinquery = "select * from Intellect where EMAIL = ? and PASSWORD = ?";
	
	private String signupquery = "insert into Intellect (NAME, EMAIL, PASSWORD) values (?,?,?)";
	
	private String usernamequery = "select NAME from Intellect where EMAIL = ?";

	public String getSigninquery() {
		return signinquery;
	}

	public String getUsernamequery() {
		return usernamequery;
	}

	public String getUrl() {
		return url;
	}

	public String getUser() {
		return user;
	}

	public String getPasswd() {
		return passwd;
	}

	public String getSignupquery() {
		return signupquery;
	}
	
	
}
