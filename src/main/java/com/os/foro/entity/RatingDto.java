package com.os.foro.entity;

import java.util.Date;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import com.googlecode.objectify.annotation.Parent;

/**
 * 
 * @author OscarEdmit
 *
 */
@Entity
public class RatingDto {
	@Id
	private Long id;
	@Load
	@Parent
	Ref<TemaDto> tema;
	@Load
	@Index
	Ref<UsuarioDto> usuario;
	@Index
	private double rate;
	@Index
	private Date fecha;

	public RatingDto() {
		super();
		// TODO Auto-generated constructor stub
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

	public UsuarioDto getUsuario() {
		if (this.usuario != null)
			return usuario.get();
		else
			return null;
	}

	public void setUsuario(UsuarioDto usuario) {
		if (usuario != null)
			this.usuario = Ref.create(usuario);
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
