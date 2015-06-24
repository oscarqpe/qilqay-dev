package com.os.foro.tema;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.cmd.Query;
import com.os.foro.entity.ComentarioDto;

/**
 * 
 * @author OscarEdmit
 *
 */
public class TemaManager {
	private static final Logger LOGGER = Logger.getLogger(TemaManager.class.getName());
	
	Query<TemaDto> query = ofy().load().type(TemaDto.class);
	
	public TemaDto registrarTema(TemaDto tema) {
		ofy().save().entity(tema).now();
		return tema;
	}
	public TemaDto getTema(Long idTema) {
		return ofy().load().type(TemaDto.class).id(idTema).get();
	}
	public List<TemaDto> temas() {
		return query.list();
	}
	public TemaDto agregarComentario(ComentarioDto comentario, Long idTema) {
		TemaDto tema = getTema(idTema);
		List<ComentarioDto> comentarios = tema.getComentarios();
		if (comentarios != null)
			comentarios.add(comentario);
		else
			comentarios = new ArrayList<ComentarioDto>();
		tema.setComentarios(comentarios);
		ofy().save().entity(tema).now();
		return tema;
	}
	public void registrarComentario(ComentarioDto comentario, Long idTema) {
		TemaDto tema = getTema(idTema);
		TemaComentarioDto temaComentario = new TemaComentarioDto();
		temaComentario.setComentario(comentario);
		temaComentario.setTema(tema);		
		temaComentario.setFecha(new Date());
		ofy().save().entity(temaComentario).now();
	}
	public List<TemaComentarioDto> getComentarios(Long id) {
		TemaDto tema = ofy().load().type(TemaDto.class).id(id).get();
		System.out.println(tema);
		List<TemaComentarioDto> comentarios = ofy().load().type(TemaComentarioDto.class)
				.ancestor(Key.create(tema)).order("-fecha").list();
		Iterator<TemaComentarioDto> iterator = comentarios.iterator();
		while(iterator.hasNext()) {
			TemaComentarioDto comentario = iterator.next();
			comentario.setComentarioRef(comentario.getComentario());
		}
		return comentarios;
	}
}
