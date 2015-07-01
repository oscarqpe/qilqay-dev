/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.os.foro.gplus.oauth;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson.JacksonFactory;
import com.google.api.services.oauth2.model.Userinfo;
import com.google.api.services.plusDomains.PlusDomains;
import com.google.api.services.plusDomains.model.Person;
import com.google.appengine.api.NamespaceManager;
import com.os.foro.entity.UsuarioDto;
import com.os.foro.helper.Helper;
import com.os.foro.helper.HelperGplus;
import com.os.foro.manager.UsuarioManager;
import com.os.foro.util.CloudSqlException;
import com.os.foro.util.OsUtil;

import java.util.Date;

/**
 *
 * @author dgparedes
 */
public class GPlusCallbackServlet extends HttpServlet {

    private static final long serialVersionUID = 7698870081108211774L;
    private static final Logger LOGGER = Logger.getLogger(GPlusCallbackServlet.class.getName());
    private static final UsuarioManager usuarioManager = new UsuarioManager();
    
    @Override
    protected void doGet(HttpServletRequest p_request, HttpServletResponse p_response) throws ServletException, IOException {

        String code = p_request.getParameter("code");

        if (OsUtil.isNullOrEmpty(code)) {
            LOGGER.info("there is no auth code on oauth callback. User unauthorized");
            p_response.sendRedirect(Helper.LOGIN_PAGE);
            return;
        }

        try {

            Credential credentials = GPlusOauth.getCredentials(code, "");
            Userinfo userinfo = GPlusOauth.getUserInfo(credentials);
            /*PlusDomains plus = new PlusDomains.Builder(new NetHttpTransport(), new JacksonFactory(), credentials).setApplicationName(GPlusHelper.GOOGLE_APP_NAME).build();
             Person domainUser = plus.people().get("me").execute();
             LOGGER.info("INFOO GPLUS CALLBACK USER INFO ");
             LOGGER.info(domainUser.toPrettyString());
             LOGGER.info("FIN INFOO GPLUS CALLBACK USER INFO ");*/

            if (credentials.getRefreshToken() == null) {
                Credential StoredCredentials = GPlusOauth.getStoredCredentials(userinfo.getEmail());
                if (StoredCredentials == null || StoredCredentials.getRefreshToken() == null) {
                    //if we dont have valid credentials, we need to force the authorization
                    String authUrl = GPlusOauth.getAuthorizationUrl(userinfo.getEmail(), "", true); //force credentials
                    p_response.sendRedirect(authUrl);
                    return;
                }
            }

            UsuarioDto netUser = new UsuarioDto();

            netUser.setEmail(userinfo.getEmail());
            netUser.setNombres(userinfo.getName());
            netUser.setUsername(userinfo.getGivenName());
            netUser.setPicture(userinfo.getPicture());
            netUser.setExpires(credentials.getExpiresInSeconds() != null ? new Date(credentials.getExpiresInSeconds()) : null);
            netUser.setExpiresInSecs(credentials.getExpiresInSeconds() != null ? credentials.getExpiresInSeconds() : null);
            netUser.setAccessToken(credentials.getAccessToken());
            netUser.setRefreshToken(credentials.getRefreshToken());
            System.out.println(netUser);
            netUser = usuarioManager.registrarUsuario(netUser);
            netUser = usuarioManager.getUserByEmail(netUser.getEmail());
            HelperGplus.setUserInformationInSession(
            		p_request, 
            		Helper.VALID_GOOGLE_USER, 
            		netUser, "oauth");

            LOGGER.info(credentials.getAccessToken());
            LOGGER.info(credentials.getRefreshToken());
            
            HttpSession session = p_request.getSession();
			session.setAttribute(Helper.USER_LOGGED_ID, netUser.getId());
			session.setAttribute(Helper.USER_LOGGED_EMAIL, netUser.getEmail());
			session.setAttribute(Helper.USER_LOGGED_USERNAME, netUser.getUsername());
			session.setAttribute(Helper.USER_LOGGED_TYPE, netUser.getUserType());
			//request.getRequestDispatcher("views/temas/temas.jsp").forward(request, response);
			p_response.sendRedirect("/temas");

        } catch (GPlusOauth.CodeExchangeException ex) {
            Logger.getLogger(GPlusCallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GPlusOauth.NoRefreshTokenException ex) {
            Logger.getLogger(GPlusCallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (GPlusOauth.NoUserIdException ex) {
            Logger.getLogger(GPlusCallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (CloudSqlException ex) {
            Logger.getLogger(GPlusCallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        p_response.sendRedirect("/temas");
    }

}
