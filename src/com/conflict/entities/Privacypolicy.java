package com.conflict.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Privacypolicy implements Serializable {
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id; 
@OneToMany(targetEntity= Assertion.class)
private List<Assertion> assertions;

@OneToMany(targetEntity= Query.class)
private List<Query> queries;

public List<Assertion> getAssertions() {
	return assertions;
}

public void setAssertions(List<Assertion> assertions) {
	this.assertions = assertions;
}

public List<Query> getQueries() {
	return queries;
}

public void setQueries(List<Query> queries) {
	this.queries = queries;
}

private String  description;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}



public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}





}
