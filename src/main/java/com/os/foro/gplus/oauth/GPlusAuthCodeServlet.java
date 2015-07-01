package com.os.foro.gplus.oauth;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
/**
 * 
 * @author OscarEdmit
 *
 */
public class GPlusAuthCodeServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(GPlusAuthCodeServlet.class.getName());
    private static final long serialVersionUID = 1L;
    
       /**
     * If the user already has a valid credential held in the
     * AuthorizationCodeFlow they are simply returned to the home page.
     */
    @Override
    protected void doGet(HttpServletRequest p_request, HttpServletResponse p_response) throws ServletException, IOException {
        
        try {
            
            GoogleAuthorizationCodeFlow flow = GPlusOauth.getFlow();
            GoogleAuthorizationCodeRequestUrl newAuthorizationUrl = flow.newAuthorizationUrl();
            newAuthorizationUrl.setRedirectUri(GPlusHelper.REDIRECT_URI);
            String redirect = newAuthorizationUrl.build();
            
            LOGGER.info(redirect);
        
            p_response.sendRedirect(redirect);
            
        } catch ( Exception e ){
            e.printStackTrace();
            LOGGER.info(e.getMessage());
        }
        //p_response.sendRedirect(authorizationUrl);
    }

}
