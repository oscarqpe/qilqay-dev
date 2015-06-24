package com.os.foro.servlets;

import java.io.IOException;
import java.lang.ProcessBuilder.Redirect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.os.foro.entity.UsuarioDto;
import com.os.foro.helper.Helper;
import com.os.foro.manager.UsuarioManager;

/**
 * 
 * @author OscarEdmit
 *
 */
public class LoginServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final UsuarioManager usuarioManager = new UsuarioManager();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/usuarios/login.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UsuarioDto usuario = usuarioManager.login(username, password);
		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute(Helper.USER_LOGGED_ID, usuario.getId());
			session.setAttribute(Helper.USER_LOGGED_EMAIL, usuario.getEmail());
			session.setAttribute(Helper.USER_LOGGED_USERNAME, usuario.getUsername());
			session.setAttribute(Helper.USER_LOGGED_TYPE, usuario.getUserType());
			//request.getRequestDispatcher("views/temas/temas.jsp").forward(request, response);
			response.sendRedirect("/temas");
		} else {
			RequestDispatcher view = request.getRequestDispatcher("views/usuarios/login.jsp"); 
			view.forward(request, response);
		}
	}
}
