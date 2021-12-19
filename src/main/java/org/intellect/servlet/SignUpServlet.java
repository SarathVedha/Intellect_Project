package org.intellect.servlet;

import java.io.IOException;
import java.sql.SQLException;

import org.intellect.base.Base;
import org.intellect.dao.DataAccessObject;
import org.intellect.pom.PageObjectManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class SignUpServlet extends jakarta.servlet.http.HttpServlet {
	private static final long serialVersionUID = 1L;

	PageObjectManager pom = new PageObjectManager();
	DataAccessObject dao = new DataAccessObject();

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			
			boolean validateUser = Base.validateSignUpUsers(Base.getUserData(request, pom.getSignupusername()), Base.getUserData(request, pom.getSignupuseremail()), Base.getUserData(request, pom.getSignupuserpassword()));
			
			if (validateUser) {
				boolean addUser = dao.addUser(Base.connectDataBase(dao.getUrl(), dao.getUser(), dao.getPasswd()), dao.getSignupquery(),
						Base.getUserData(request, pom.getSignupusername()),
						Base.getUserData(request, pom.getSignupuseremail()),
						Base.getUserData(request, pom.getSignupuserpassword()));
				
				if (addUser) {
					Base.getSession(request);
					Base.setSessionAttribute(pom.getAdduser(), pom.getAdduservalue());
					Base.sendRedirect(response, pom.getIndexpage());
				} else {
					Base.getSession(request);
					Base.setSessionAttribute(pom.getUserexist(), pom.getUserexistvalue());
					Base.sendRedirect(response, pom.getIndexpage());
				}
				
			} else {
				
				Base.getSession(request);
				Base.setSessionAttribute(pom.getValidateError(), pom.getValidateErrorValue());
				Base.sendRedirect(response, pom.getIndexpage());
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			
			System.out.println(e);
		}
	}

}
