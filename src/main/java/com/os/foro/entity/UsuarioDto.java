package com.os.foro.entity;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
/**
 * 
 * @author OscarEdmit
 *
 */
@Entity
public class UsuarioDto {
	@Id
	private Long id;
	@Index
	private String username;
	@Index
	private String password;
	@Index
	private GroupUserType userType;
	@Index
	private String email;
	@Index
	private String picture;
	@Index 
	private Boolean agreement;
	
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
	@Override
	public String toString() {
		return "UsuarioDto [id=" + id + ", username=" + username
				+ ", password=" + password + ", userType=" + userType
				+ ", email=" + email + ", agreement=" + agreement + "]";
	}
}
