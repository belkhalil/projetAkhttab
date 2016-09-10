package com.conflict.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.sun.xml.internal.ws.developer.StreamingAttachment;



@Entity
public class law implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String nom;
	private String covered;
	
	public law() {
		super();
		// TODO Auto-generated constructor stub
	}

	public law(String nom, String covered) {
		super();
		this.nom = nom;
		this.covered = covered;
		
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCovered() {
		return covered;
	}

	public void setCovered(String covered) {
		this.covered = covered;
	}

	@OneToOne
	private Privacypolicy  privacypolicy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Privacypolicy getPrivacypolicy() {
		return privacypolicy;
	}

	public void setPrivacypolicy(Privacypolicy privacypolicy) {
		this.privacypolicy = privacypolicy;
	}

	
}
