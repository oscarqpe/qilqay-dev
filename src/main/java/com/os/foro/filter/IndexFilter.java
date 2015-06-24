package com.os.foro.filter;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.os.foro.helper.Helper;
import com.os.foro.util.OsUtil;

/**
 * 
 * @author OscarEdmit
 *
 */
public class IndexFilter implements Filter {

    protected static final Logger LOGGER = Logger.getLogger(IndexFilter.class.getName());

    public void doFilter(ServletRequest p_request, ServletResponse p_response, FilterChain p_filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) p_request;
        HttpServletResponse response = (HttpServletResponse) p_response;
        HttpSession session = request.getSession(false);

        if (session == null) {
            LOGGER.log(Level.INFO, "NO SESSION FOUND");
            response.sendRedirect(Helper.LOGIN_PAGE);
            return;
        }

        LOGGER.info("CHECK FOR VALID USER");
        Boolean validUser = true;

        //create the traffic splitting cookie only for NS intelygenz.com and nextinit.com
        //NxtCookies.createOrUpdateTrafficSplittingCookie(response, namespace);
        String userLoggedEmail = (String) session.getAttribute(Helper.USER_LOGGED_EMAIL);
        if (OsUtil.isNullOrEmpty(userLoggedEmail)) {
            LOGGER.warning("INVALID USER_LOGGED_EMAIL IN SESSION");
            validUser = false;
        }

        if (validUser == false) {
            LOGGER.warning("INVALID SESSION -> LOGOUT USER");
            Helper.forceLogout(session, response);
            return;
        }

        //update the JSESSIONID with new maxAge
        //HttpServletResponse responseWithCookie = NxtCookies.updateJsessionCookie(request, response);
        //valid user in session, continue the request
        p_filterChain.doFilter(request, response);
    }

    public void destroy() {
    }

    public void init(FilterConfig arg0) throws ServletException {
    }

}
