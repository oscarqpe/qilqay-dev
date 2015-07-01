package com.os.foro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.os.foro.entity.TemaDto;
import com.os.foro.helper.Helper;
import com.os.foro.manager.TemaManager;
/**
 * 
 * @author OscarEdmit
 *
 */
public class RegistrarTemaServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final TemaManager temaManager = new TemaManager();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!Helper.filterSession(request,response)) response.sendRedirect(Helper.LOGIN_PAGE);
		TilesContainer container = TilesAccess.getContainer(
				request.getSession().getServletContext());
		container.render("/nuevo-tema", request, response);
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!Helper.filterSession(request,response)) response.sendRedirect(Helper.LOGIN_PAGE);
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		
		System.out.println("Titulo: " + titulo);
		System.out.println("Descripcion: " + descripcion);
		
		TemaDto tema = new TemaDto();
		tema.setTitulo(titulo);
		tema.setContenido(descripcion);
		tema = temaManager.registrarTema(tema);
		//request.getRequestDispatcher("views/temas/create.jsp").forward(request, response);
		
		response.sendRedirect("/foro?_key=" + tema.getId());
	}
}
