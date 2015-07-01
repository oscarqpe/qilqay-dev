package com.os.foro.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.os.foro.entity.RatingDto;
import com.os.foro.helper.Helper;
import com.os.foro.manager.RatingManager;
import com.os.foro.util.OsUtil;

/**
 * 
 * @author OscarEdmit
 *
 */
public class VoteServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final RatingManager ratingManager = new RatingManager();

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (!Helper.filterSession(request, response))
			response.sendRedirect(Helper.LOGIN_PAGE);
		HttpSession session = request.getSession();
		Long idUsuario = (Long) session.getAttribute(Helper.USER_LOGGED_ID);
		String idTemaStr = request.getParameter("idTema");
		Long idTema = Long.parseLong(idTemaStr);
		String voteStr = request.getParameter("rating");
		double vote = Double.parseDouble(voteStr);
		RatingDto rating = new RatingDto();
		rating.setRate(OsUtil.round(vote, 2));
		rating = ratingManager.registrarRating(rating, idTema, idUsuario);
		response.sendRedirect("/foro?_key=" + idTema.toString());
	}

}
