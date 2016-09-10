package com.conflict.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Beh implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private Long id ;


public Beh() {
	super();
	// TODO Auto-generated constructor stub
}
private String Cont;
private String Act;
private String Subj;
private String Purp;
private String Ress;
private String Cond;
private String DiscloseTo;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public String getCont() {
	return Cont;
}
public void setCont(String cont) {
	Cont = cont;
}
public String getAct() {
	return Act;
}
public void setAct(String act) {
	Act = act;
}
public String getSubj() {
	return Subj;
}
public void setSubj(String subj) {
	Subj = subj;
}
public String getPurp() {
	return Purp;
}
public void setPurp(String purp) {
	Purp = purp;
}
public String getRess() {
	return Ress;
}
public void setRess(String ress) {
	Ress = ress;
}
public String getCond() {
	return Cond;
}
public void setCond(String cond) {
	Cond = cond;
}
public String getDiscloseTo() {
	return DiscloseTo;
}
public void setDiscloseTo(String discloseTo) {
	DiscloseTo = discloseTo;
}




}
