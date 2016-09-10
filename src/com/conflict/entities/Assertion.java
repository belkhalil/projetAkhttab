package com.conflict.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;



@Entity
public class Assertion implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long  id ; 
	
	private String Contenu;
	
   @OneToMany(targetEntity=Fact.class)
   private List<Fact> facts;
   
	public String getContenu() {
	return Contenu;
}
public void setContenu(String contenu) {
	Contenu = contenu;
}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Fact> getFacts() {
		return facts;
	}
	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}
	
	

}
