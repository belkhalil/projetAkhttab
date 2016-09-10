package com.conflict.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.conflict.entities.Assertion;
import com.conflict.entities.UserPref;
import com.conflict.services.UserPrefServices;

public class UserPrefDao implements UserPrefServices {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
	EntityManager em = emfactory.createEntityManager();

	@Override
	public UserPref get(Long id) {
		em.getTransaction().begin();
		UserPref a = em.find(UserPref.class, id);
		em.getTransaction().commit();
		return a;
	}

	@Override
	public UserPref Add(UserPref userPref) {

		try {
			em.getTransaction().begin();
			em.persist(userPref);
			em.getTransaction().commit();
			return userPref;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public UserPref Update(UserPref userPref) {
		try {
			em.getTransaction().begin();
			em.merge(userPref);
			em.getTransaction().commit();
			return userPref;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public List<UserPref> getAll() {
		Query query = em.createQuery("SELECT a FROM com.conflict.entities.UserPref a", UserPref.class);
		List<UserPref> a = query.getResultList();
		return a;
	}

	@Override
	public Boolean delete(Long idUserpref) {
		try {
			em.getTransaction().begin();
			em.remove(idUserpref);
			em.getTransaction().commit();

			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public UserPref AddQueryUserPref(com.conflict.entities.Query query, UserPref userPref) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserPref AddAssertionToUsrPref(Assertion assertion, UserPref userPref) {
		try {
			em.getTransaction().begin();
			userPref.getAssertions().add(assertion);
			em.persist(userPref);
			em.getTransaction().commit();
			return userPref;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

}
