package com.os.foro.manager;

import static com.googlecode.objectify.ObjectifyService.ofy;

import java.util.Date;
import java.util.List;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.os.foro.entity.RatingDto;
import com.os.foro.entity.TemaComentarioDto;
import com.os.foro.entity.TemaDto;
import com.os.foro.entity.UsuarioDto;
import com.os.foro.util.OsUtil;

/**
 * 
 * @author OscarEdmit
 *
 */
public class RatingManager {
	private static final TemaManager temaManager = new TemaManager();
	private static final UsuarioManager usuarioManager = new UsuarioManager();
	public RatingDto registrarRating(RatingDto rating, Long idTema, Long idUsuario) {
		TemaDto tema =  temaManager.getTema(idTema);
		UsuarioDto usuario = usuarioManager.getUsuario(idUsuario);
		RatingDto ratingExiste = ofy().load().type(RatingDto.class)
				.ancestor(Key.create(tema)).filter("usuario", Ref.create(usuario)).first().now();
		if (ratingExiste== null) {
			rating.setTema(tema);
			rating.setUsuario(usuario);
			rating.setFecha(new Date());
			ofy().save().entity(rating).now();
		} else {
			rating.setId(ratingExiste.getId());
			rating.setTema(tema);
			rating.setUsuario(usuario);
			rating.setFecha(ratingExiste.getFecha());
			ofy().save().entity(rating).now();
		}
		
		List<RatingDto> ratings = ofy().load().type(RatingDto.class)
				.ancestor(Key.create(tema)).list();
		double promedioRating = 0.0;
		for (RatingDto ratingDto : ratings) {
			promedioRating += ratingDto.getRate();
		}
		promedioRating = promedioRating / ratings.size();
		tema.setRate(OsUtil.round(promedioRating, 2));
		ofy().save().entity(tema).now();
		return rating;
	}
}
