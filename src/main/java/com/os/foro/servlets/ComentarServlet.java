package com.os.foro.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.os.foro.entity.ComentarioDto;
import com.os.foro.entity.TemaDto;
import com.os.foro.entity.UsuarioDto;
import com.os.foro.manager.ComentarioManager;
import com.os.foro.manager.TemaManager;
import com.os.foro.manager.UsuarioManager;
/**
 * 
 * @author OscarEdmit
 *
 */
public class ComentarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final ComentarioManager comentarioManager = new ComentarioManager();
	private static final TemaManager temaManager = new TemaManager();
	private static final UsuarioManager usuarioManager = new UsuarioManager();
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String idTema = request.getParameter("idTema");
		System.out.println(idTema);
		String nombres = request.getParameter("nombres");
		System.out.println(nombres);
		String comentario = request.getParameter("comentario");
		System.out.println(comentario);
		
		ComentarioDto comment = new ComentarioDto();
		comment.setDescripcion(comentario);
		
		UsuarioDto usuario = new UsuarioDto();
		usuario.setUsername(nombres);
		usuario = usuarioManager.registrarUsuario(usuario);
		comment.setUsuario(usuario);
		comment = comentarioManager.registrarComentario(comment);
		
		System.out.println(comment);
		
		Long id = Long.parseLong(idTema);
		TemaDto tema = temaManager.getTema(id);
		
		/*List<TemaComentarioDto> comentarios = */temaManager.registrarComentario(comment, id);
		//tema = temaManager.agregarComentario(comment, id);
		
		response.sendRedirect("/foro?_key=" + id.toString());
	}
	
}
