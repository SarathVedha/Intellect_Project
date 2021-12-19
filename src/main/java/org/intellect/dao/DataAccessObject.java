package org.intellect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataAccessObject extends DataBase {

	@Override
	public String getUrl() {
		// TODO Auto-generated method stub
		return super.getUrl();
	}

	@Override
	public String getUser() {
		// TODO Auto-generated method stub
		return super.getUser();
	}

	@Override
	public String getPasswd() {
		// TODO Auto-generated method stub
		return super.getPasswd();
	}

	@Override
	public String getSigninquery() {
		// TODO Auto-generated method stub
		return super.getSigninquery();
	}

	@Override
	public String getSignupquery() {
		// TODO Auto-generated method stub
		return super.getSignupquery();
	}

	@Override
	public String getUsernamequery() {
		// TODO Auto-generated method stub
		return super.getUsernamequery();
	}

	public boolean validateUser(Connection connection, String query, String useremail, String userpassword)
			throws SQLException {

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setString(1, useremail);
		prepareStatement.setString(2, userpassword);

		ResultSet resultSet = prepareStatement.executeQuery();

		if (resultSet.next()) {
			
			return true;
		} else {
			
			return false;
		}
	}

	public boolean addUser(Connection connection, String queryString, String usernameString, String useremailString,
			String userpasswordString) throws SQLException {

		try {
			PreparedStatement prepareStatement = connection.prepareStatement(queryString);
			prepareStatement.setString(1, usernameString);
			prepareStatement.setString(2, useremailString);
			prepareStatement.setString(3, userpasswordString);

			int executeUpdate = prepareStatement.executeUpdate();

			if (executeUpdate > 0) {
				
				return true;
			}

		} catch (SQLException e) {
			System.out.println(e);
		}

		return false;
	}

	public String getUserName(Connection connection, String queryString, String useremailString) {

		String valueString = null;
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setString(1, useremailString);

			ResultSet executeQuery = preparedStatement.executeQuery();
			executeQuery.next();
			valueString = executeQuery.getString(1);

			if (valueString != null) {
				
				return valueString;
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		return valueString;
	}

}
