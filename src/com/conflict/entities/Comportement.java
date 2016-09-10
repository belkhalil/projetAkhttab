package com.conflict.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Comportement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id; 
	
	private String contenu;
	private String action;
	private String objet;
	private String objectif;
	private String Ressources;
	private String communiquerAux;
	public Comportement() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Comportement(Long id, String contenu, String action, String objet, String objectif, String ressources,
			String communiquerAux) {
		super();
		this.id = id;
		this.contenu = contenu;
		this.action = action;
		this.objet = objet;
		this.objectif = objectif;
		Ressources = ressources;
		this.communiquerAux = communiquerAux;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	public String getObjet() {
		return objet;
	}
	public void setObjet(String objet) {
		this.objet = objet;
	}
	public String getObjectif() {
		return objectif;
	}
	public void setObjectif(String objectif) {
		this.objectif = objectif;
	}
	public String getRessources() {
		return Ressources;
	}
	public void setRessources(String ressources) {
		Ressources = ressources;
	}
	public String getCommuniquerAux() {
		return communiquerAux;
	}
	public void setCommuniquerAux(String communiquerAux) {
		this.communiquerAux = communiquerAux;
	}
	
	
	
}
