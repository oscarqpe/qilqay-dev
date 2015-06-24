package com.os.foro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.os.foro.entity.GroupUserType;
import com.os.foro.entity.UsuarioDto;
import com.os.foro.helper.Helper;
import com.os.foro.manager.UsuarioManager;
import com.os.foro.util.OsUtil;

/**
 * 
 * @author OscarEdmit
 *
 */
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final UsuarioManager usuarioManager = new UsuarioManager();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/usuarios/register.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String agreement = request.getParameter("agreement");
		System.out.println("Agree: " + agreement);
		UsuarioDto usuario = new UsuarioDto();
		usuario.setEmail(email);
		usuario.setUsername(username);
		usuario.setUserType(GroupUserType.USER);
		usuario.setPassword(OsUtil.getSecurePassword(password));
		if (agreement != null) {
			if (agreement.equals("on"))
				usuario.setAgreement(Boolean.TRUE);
			else
				usuario.setAgreement(Boolean.FALSE);
		} else {
			usuario.setAgreement(Boolean.FALSE);
		}
		usuario = usuarioManager.registrarUsuario(usuario);
		if (usuario != null) {
			HttpSession session = request.getSession();
			session.setAttribute(Helper.USER_LOGGED_ID, usuario.getId());
			session.setAttribute(Helper.USER_LOGGED_EMAIL, usuario.getEmail());
			session.setAttribute(Helper.USER_LOGGED_USERNAME, usuario.getUsername());
			session.setAttribute(Helper.USER_LOGGED_TYPE, usuario.getUserType());
			request.getRequestDispatcher("views/temas/temas.jsp").forward(request, response);
		}
		request.setAttribute("Success", true);
		request.setAttribute("Message", "Registro incorrecto");
		request.getRequestDispatcher("views/usuarios/register.jsp").forward(request, response);
	}
}
