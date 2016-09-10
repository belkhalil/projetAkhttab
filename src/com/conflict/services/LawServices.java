package com.conflict.services;

import java.util.List;

import com.conflict.entities.Privacypolicy;
import com.conflict.entities.law;

public interface LawServices {

	public law get(Long id);
	public  law Add(law law);
	public law Update(law law);
	public List<law> getAll();
	public Boolean delete(Long idLaw);
	public law AddPrivacyToLaw(Privacypolicy p,law l);
}
