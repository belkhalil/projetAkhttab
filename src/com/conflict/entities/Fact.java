package com.conflict.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Fact implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id ;


@ManyToOne
@JoinColumn(name="idAssertion")
private Assertion assertion;


private String Contenu;

@OneToOne(targetEntity= Beh.class)
private Beh behavior ;

public Assertion getAssertion() {
	return assertion;
}


public void setAssertion(Assertion assertion) {
	this.assertion = assertion;
}


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


public Beh getBehavior() {
	return behavior;
}


public void setBehavior(Beh behavior) {
	this.behavior = behavior;
}


}
