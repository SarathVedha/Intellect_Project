package org.intellect.servlet;

import java.io.IOException;

import org.intellect.base.Base;
import org.intellect.pom.PageObjectManager;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PageObjectManager pom = new PageObjectManager();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Base.getSession(request);
		Base.removeSessionAttribute(pom.getSigninuseremail());
		Base.removeSessionAttribute(pom.getUsername());
		Base.invalidateSession();
		Base.sendRedirect(response, pom.getIndexpage());
	}

}
