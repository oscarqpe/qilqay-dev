package com.os.foro.tema;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Ignore;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.OnLoad;
import com.googlecode.objectify.annotation.Parent;
import com.os.foro.entity.ComentarioDto;

@Entity
public class TemaComentarioDto {
	@Id
	private Long id;
	@Load @Parent Ref<TemaDto> tema;
	@Load @Index Ref<ComentarioDto> comentario;
	@Index
	private Date fecha;
	
	@Ignore private ComentarioDto comentarioRef;
	
	@OnLoad
	public void getRefs() {
		if (comentario.isLoaded())
			if (comentario != null)
				comentarioRef = comentario.get();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TemaDto getTema() {
		if (tema != null)
			return tema.get();
		else 
			return null;
	}

	public void setTema(TemaDto tema) {
		if (tema != null)
		this.tema = Ref.create(tema);
	}

	public ComentarioDto getComentario() {
		if (comentario != null)
			return comentario.get();
		else return null;
	}

	public void setComentario(ComentarioDto comentario) {
		if (comentario != null)
		this.comentario = Ref.create(comentario);
	}

	public ComentarioDto getComentarioRef() {
		return comentarioRef;
	}

	public void setComentarioRef(ComentarioDto comentarioRef) {
		this.comentarioRef = comentarioRef;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "TemaComentarioDto [id=" + id + ", tema=" + tema
				+ ", comentario=" + comentario + ", comentarioRef="
				+ comentarioRef + "]";
	}
}
