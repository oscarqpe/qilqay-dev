package com.os.foro.manager;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.cmd.Query;
import com.os.foro.entity.ComentarioDto;
/**
 * 
 * @author OscarEdmit
 *
 */
public class ComentarioManager {
	private static final Logger LOGGER = Logger.getLogger(ComentarioManager.class.getName());

	Query<ComentarioDto> query = ofy().load().type(ComentarioDto.class);
	
	public ComentarioDto registrarComentario (ComentarioDto comentario) {
		ofy().save().entity(comentario).now();
		return comentario;
	}
	public ComentarioDto getComentario(Long idComentario) {
		return ofy().load().type(ComentarioDto.class).id(idComentario).get();
	}
	public List<ComentarioDto> getComentarios() {
		return query.list();
	}
}
