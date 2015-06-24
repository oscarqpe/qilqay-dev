package com.os.foro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * @author OscarEdmit
 *
 */
public class RetrieveServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/usuarios/retrieve.jsp").forward(request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) {
		
	}
}
