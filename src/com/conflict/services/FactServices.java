package com.conflict.services;

import java.util.List;

import com.conflict.entities.Beh;
import com.conflict.entities.Fact;

public interface FactServices {

	public Fact get(Long id);
	public  Fact Add(Fact fact);
	public Fact Update(Fact fact);
	public List<Fact> getAll();
	public Boolean delete(Long idFact);
	public Fact addBehaviorToFact(Beh beh, Fact fact);
	default Boolean Contain(String stringToSearch, String sentence) {
		Boolean contains = sentence.matches(".*\\b"+stringToSearch+"\\b.*");
		return contains;
	}
}
