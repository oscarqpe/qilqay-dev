package com.os.foro.entity;

import java.io.Serializable;
import java.util.Date;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
/**
 * 
 * @author OscarEdmit
 *
 */
@Entity
public class UsuarioDto implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private Long id;
	@Index
	private String username;
	@Index
	private String password;
	@Index
	private String nombres;
	@Index
	private GroupUserType userType;
	@Index
	private String email;
	@Index
	private String picture;
	@Index 
	private Boolean agreement;
	@Index
	private String accessToken;
	@Index
	private String refreshToken;
	@Index
	private Date expires;
	@Index
	private Long expiresInSecs;
	
	public UsuarioDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public GroupUserType getUserType() {
		return userType;
	}
	public void setUserType(GroupUserType userType) {
		this.userType = userType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getAgreement() {
		return agreement;
	}
	public void setAgreement(Boolean agreement) {
		this.agreement = agreement;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public Date getExpires() {
		return expires;
	}
	public void setExpires(Date expires) {
		this.expires = expires;
	}
	public Long getExpiresInSecs() {
		return expiresInSecs;
	}
	public void setExpiresInSecs(Long expiresInSecs) {
		this.expiresInSecs = expiresInSecs;
	}
	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", username=" + username
				+ ", password=" + password + ", userType=" + userType
				+ ", email=" + email + ", agreement=" + agreement + "]";
	}
}
