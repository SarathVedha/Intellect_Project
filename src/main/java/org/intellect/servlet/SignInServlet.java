package org.intellect.servlet;

import java.io.IOException;
import java.sql.SQLException;
import org.intellect.base.Base;
import org.intellect.dao.DataAccessObject;
import org.intellect.pom.PageObjectManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PageObjectManager pom = new PageObjectManager();
	DataAccessObject dao = new DataAccessObject();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			boolean validateUsers = Base.validateUsers(Base.getUserData(request, pom.getSigninuseremail()), Base.getUserData(request, pom.getSigninuserpassword()));
			
			if (validateUsers) {
				
				boolean validateUser = dao.validateUser(Base.connectDataBase(dao.getUrl(), dao.getUser(), dao.getPasswd()),
						dao.getSigninquery(), Base.getUserData(request, pom.getSigninuseremail()),
						Base.getUserData(request, pom.getSigninuserpassword()));
				if (validateUser) {
					Base.getSession(request);
					Base.setSessionAttribute(pom.getSigninuseremail(), Base.getUserData(request, pom.getSigninuseremail()));
					String userName = dao.getUserName(Base.connectDataBase(dao.getUrl(), dao.getUser(), dao.getPasswd()), dao.getUsernamequery(), Base.getUserData(request, pom.getSigninuseremail()));
					Base.setSessionAttribute(pom.getUsername(), userName);
					Base.sendRedirect(response, pom.getWelcomepage());
				} else {
					Base.getSession(request);
					Base.setSessionAttribute(pom.getError(), pom.getError());
					Base.sendRedirect(response, pom.getIndexpage());
				}
				
			} else {
				
				Base.getSession(request);
				Base.setSessionAttribute(pom.getValidateError(), pom.getValidateErrorValue());
				Base.sendRedirect(response, pom.getIndexpage());
			}
			
		} catch (SQLException | ClassNotFoundException e) {

			System.out.println(e);
		}

	}

}
