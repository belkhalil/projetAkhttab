package com.conflict.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class HealthProvider  implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="Nom")
	private String nom; 
	
	@Column(name="Location")
	private String location;
	
   @OneToOne(targetEntity=Privacypolicy.class)
    private Privacypolicy  privacypolicy;

	
	
	public HealthProvider(String nom, String location) {
		super();
		this.nom = nom;
		this.location = location;
	}
	public HealthProvider() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
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
