package com.os.foro.servlets;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.os.foro.helper.Helper;

/**
 * 
 * @author OscarEdmit
 *
 */
public class LogoutServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger LOGGER = Logger.getLogger(LogoutServlet.class.getName());

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		LOGGER.info("Force logout in LogoutServlet");

        UserService userService = UserServiceFactory.getUserService();
        Helper.forceLogoutAndRedirectTo(request.getSession(), response, 
        		userService.createLogoutURL(Helper.LOGIN_PAGE));
	}
}
