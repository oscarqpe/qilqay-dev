package com.os.foro.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tiles.TilesContainer;
import org.apache.tiles.access.TilesAccess;

import com.os.foro.entity.TemaComentarioDto;
import com.os.foro.entity.TemaDto;
import com.os.foro.helper.Helper;
import com.os.foro.manager.TemaManager;
/**
 * 
 * @author OscarEdmit
 *
 */
public class ForoInicioServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final TemaManager temaManager = new TemaManager();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!Helper.filterSession(request,response)) response.sendRedirect(Helper.LOGIN_PAGE);
		String idTema = request.getParameter("_key");
		System.out.println("Key: " + idTema);
		Long id = Long.parseLong(idTema);
		TemaDto tema = temaManager.getTema(id);
	
		List<TemaComentarioDto> comentarios = temaManager.getComentarios(id);
		
		System.out.println("Size: " + comentarios.size());
		request.setAttribute("tema", tema);
		request.setAttribute("comentarios", comentarios);
		System.out.println(tema);
		//request.getRequestDispatcher("views/temas/foro.jsp").forward(request, response);
		TilesContainer container = TilesAccess.getContainer(
				request.getSession().getServletContext());
		container.render("/foro", request, response);
	}
}
