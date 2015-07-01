package com.os.foro.helper;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.os.foro.filter.IndexFilter;
import com.os.foro.util.OsUtil;
/**
 * 
 * @author OscarEdmit
 *
 */
public class Helper {
	protected static final Logger LOGGER = Logger.getLogger(Helper.class.getName());
	public static final String USER_LOGGED_EMAIL = "USER_LOGGED_EMAIL";
    public static final String USER_LOGGED_ID = "USER_LOGGED_ID";
    public static final String USER_LOGGED_TYPE = "USER_LOGGED_TYPE";
    public static final String USER_LOGGED_USERNAME = "USER_LOGGED_USERNAME";
    public static final String USER_LOGGED = "USER_LOGGED";
    
    public static final String VALID_GOOGLE_USER = "VALID_GOOGLE_USER";
    
    public static final String LOGIN_PAGE = "/login";
    
    public static void clearSession(HttpSession p_session) {
        p_session.invalidate();
    }
    
    public static void forceLogout(HttpSession p_session, HttpServletResponse p_response) throws IOException {
        forceLogoutAndRedirectTo(p_session, p_response, LOGIN_PAGE);
    }
    public static void forceLogoutAndRedirectTo(HttpSession p_session, HttpServletResponse p_response, String p_redirect) throws IOException {
        Helper.clearSession(p_session);
        p_response.sendRedirect(p_redirect);
    }
    public static Boolean filterSession(
    		ServletRequest p_request, 
    		ServletResponse p_response) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) p_request;
        HttpServletResponse response = (HttpServletResponse) p_response;
        HttpSession session = request.getSession(false);

        if (session == null) {
            //LOGGER.log(Level.INFO, "NO SESSION FOUND");
        	System.out.println("------------------------>" + "NO SESSION FOUND");
            //response.sendRedirect(Helper.LOGIN_PAGE);
            return false;
        }
        else {
        	String userLoggedEmail = (String) session.getAttribute(Helper.USER_LOGGED_EMAIL);
        	if (OsUtil.isNullOrEmpty(userLoggedEmail)) {
        		System.out.println("-------------->" + "NO USER FOUND");
        		return false;
        	}
        	//LOGGER.log(Level.INFO, session.toString());
        	System.out.println("------------------------>" + session.toString());
        	return true;
        }
    }
}
