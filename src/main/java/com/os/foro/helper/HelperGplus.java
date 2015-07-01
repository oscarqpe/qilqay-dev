package com.os.foro.helper;

import javax.servlet.http.HttpServletRequest;

import com.os.foro.entity.UsuarioDto;
/**
 * 
 * @author OscarEdmit
 *
 */
public class HelperGplus {
	public static void setUserInformationInSession(
			HttpServletRequest p_request, 
			String p_validUser, 
			UsuarioDto p_user, 
			String p_loginMethod) {
        // we have a valid yammer user in session
        p_request.getSession().setAttribute(p_validUser, true);
        p_request.getSession().setAttribute(Helper.USER_LOGGED, p_user);
        p_request.getSession().setAttribute(Helper.USER_LOGGED_EMAIL, p_user.getEmail());
    }
}
