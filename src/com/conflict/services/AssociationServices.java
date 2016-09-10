package com.conflict.services;

import java.util.List;

import com.conflict.entities.Assertion;
import com.conflict.entities.Fact;


public interface AssociationServices {

	public Assertion get(Long id);
	public  Assertion Add(Assertion assertion);
	public Assertion Update(Assertion assertion);
	public List<Assertion> getAll();
	public Boolean delete(Long idAsertion);
	public Assertion AddFactToAssertion(Fact fact, Assertion assertion);
	
	
	
}
