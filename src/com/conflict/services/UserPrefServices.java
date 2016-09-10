package com.conflict.services;

import java.util.List;

import com.conflict.entities.Assertion;
import com.conflict.entities.Query;
import com.conflict.entities.UserPref;

public interface UserPrefServices {
	
	public UserPref get(Long id);
	public  UserPref Add(UserPref userPref);
	public UserPref Update(UserPref userPref);
	public List<UserPref> getAll();
	public Boolean delete(Long idUserPref);
	public UserPref AddQueryUserPref(Query query, UserPref userPref);
	public UserPref AddAssertionToUsrPref(Assertion assertion, UserPref userPref);  
}
