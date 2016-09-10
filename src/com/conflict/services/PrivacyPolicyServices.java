package com.conflict.services;

import java.util.List;

import com.conflict.entities.Assertion;
import com.conflict.entities.Privacypolicy;
import com.conflict.entities.Query;

public interface PrivacyPolicyServices {

	public Privacypolicy get(Long id);
	public  Privacypolicy Add(Privacypolicy privacypolicy);
	public Privacypolicy Update(Privacypolicy privacypolicy);
	public List<Privacypolicy> getAll();
	public Boolean delete(Long idPrivacyPolicy);
	public Privacypolicy AddQueryToPrivacy(Query query, Privacypolicy privacypolicy);
	public Privacypolicy AddAssertionToPrivacy(Assertion assertion,Privacypolicy privacypolicy);
}
