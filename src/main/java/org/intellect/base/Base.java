package org.intellect.base;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Base extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static HttpSession session;

	public static String getUserData(HttpServletRequest request, String value) {

		String parameter = request.getParameter(value);

		return parameter;
	}

	public static void write(HttpServletResponse response, String value) throws IOException {

		response.getWriter().println(value);
	}

	public static boolean validateUsers(String email, String passwd) {

		if (email != null && email.trim().length() > 0 && passwd != null && passwd.trim().length() >= 8 ) {
			
			return true;
		} else {
			
			return false;
		}
	}

	public static Connection connectDataBase(String url, String user, String password)
			throws SQLException, ClassNotFoundException {

		Class.forName("org.postgresql.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		return connection;
	}

	public static void sendRedirect(HttpServletResponse response, String page) throws IOException {

		response.sendRedirect(page);

	}

	public static HttpSession getSession(HttpServletRequest request) {

		session = request.getSession();
		return session;
	}

	public static void setSessionAttribute(String name, String value) {

		session.setAttribute(name, value);
	}

	public static String getSessionAttribute(String name) {

		String attribute = (String) session.getAttribute(name);

		return attribute;
	}

	public static void removeSessionAttribute(String name) {

		session.removeAttribute(name);
	}
	
	public static void invalidateSession() {

		session.invalidate();
	}

	public static void setHeader(HttpServletResponse response) {

		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	}
	
	public static boolean validateSignUpUsers(String name, String email, String passwd) {
		
		if (name != null && name.trim().length() > 0 && email != null && email.trim().length() > 0 && passwd != null && passwd.trim().length() >= 8) {
			
			return true;
		} else {

			return false;
		}
	}
	
}
