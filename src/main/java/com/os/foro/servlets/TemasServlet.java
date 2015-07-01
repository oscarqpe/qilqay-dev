package com.os.foro.servlets;

import java.io.IOException;
import java.util.List;

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
public class TemasServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final TemaManager temaManager = new TemaManager();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!Helper.filterSession(request,response)) response.sendRedirect(Helper.LOGIN_PAGE);
		List<TemaDto> temas = temaManager.temas();
		request.setAttribute("temas", temas);
		//request.getRequestDispatcher("views/temas/temas.jsp").forward(request, response);
		TilesContainer container = TilesAccess.getContainer(
				request.getSession().getServletContext());
		container.render("/temas", request, response);
	}
}
