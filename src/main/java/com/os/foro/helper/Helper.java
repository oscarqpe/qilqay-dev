package com.os.foro.helper;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Helper {
	public static final String USER_LOGGED_EMAIL = "USER_LOGGED_EMAIL";
    public static final String USER_LOGGED_ID = "USER_LOGGED_ID";
    public static final String USER_LOGGED_TYPE = "USER_LOGGED_TYPE";
    public static final String USER_LOGGED_USERNAME = "USER_LOGGED_USERNAME";
    public static final String USER_LOGGED = "USER_LOGGED";
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
}
