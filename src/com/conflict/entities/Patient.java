package com.conflict.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Patient implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id ;

private String nom;
private String pays;
private String privacyGroup;      //list deroulante 
private String location;

public Patient(Long id, String nom, String pays, String privacyGroup, String location) {
	super();
	this.id = id;
	this.nom = nom;
	this.pays = pays;
	this.privacyGroup = privacyGroup;
	this.location = location;
}
public Patient() {
	super();
	// TODO Auto-generated constructor stub
}
public String getNom() {
	return nom;
}
public void setNom(String nom) {
	this.nom = nom;
}
public String getPays() {
	return pays;
}
public void setPays(String pays) {
	this.pays = pays;
}
public String getPrivacyGroup() {
	return privacyGroup;
}
public void setPrivacyGroup(String privacyGroup) {
	this.privacyGroup = privacyGroup;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
@OneToOne
private UserPref userpref;

public UserPref getUserpref() {
	return userpref;
}
public void setUserpref(UserPref userpref) {
	this.userpref = userpref;
}
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
} 

	
	
}
