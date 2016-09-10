package com.conflict.services;

import java.util.List;

import com.conflict.entities.Beh;


public interface BehaviorServices {

	public Beh get(Long id);
	public  Beh Add(Beh behavior);
	public Beh Update(Beh behavior);
	public List<Beh> getAll();
	public Boolean delete(Long idBehavior);
	
}
