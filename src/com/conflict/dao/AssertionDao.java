package com.conflict.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.conflict.entities.Assertion;
import com.conflict.entities.Fact;
import com.conflict.entities.HealthProvider;
import com.conflict.services.AssociationServices;

public class AssertionDao implements AssociationServices {

	
//	  public static void main(String[] args) {
//	  
//	  EntityManagerFactory emfactory=
//	  Persistence.createEntityManagerFactory("ConflictDetectionv1"); EntityManager
//	  em= emfactory.createEntityManager(); em.getTransaction().begin();
//	  HealthProvider healthProvider = new HealthProvider();
//	  healthProvider.setNom("helth pro");
//	  healthProvider.setLocation("location"); em.persist(healthProvider);
//	  em.getTransaction().commit(); em.close(); emfactory.close(); }
	 
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
	EntityManager em = emfactory.createEntityManager();

	/**
	 * fonction pour ajouter une nouvelle assertion
	 */

	@Override
	public Assertion get(Long id) {
		em.getTransaction().begin();
		Assertion a = em.find(Assertion.class, id);
		em.getTransaction().commit();
		return a;
	}

	@Override
	public Assertion Add(Assertion assertion) {

		try {
			em.getTransaction().begin();
			em.persist(assertion);
			em.getTransaction().commit();
			return assertion;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public Assertion Update(Assertion assertion) {
		try {
			em.getTransaction().begin();
			em.merge(assertion);
			em.getTransaction().commit();
			return assertion;
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			return null;
		}
	}

	@Override
	public List<Assertion> getAll() {
		Query query = em.createQuery("SELECT a FROM com.conflict.entities.Assertion a", Assertion.class);
		List<Assertion> a = query.getResultList();
		return a;
	}

	@Override
	public Boolean delete(Long idAssertion) {
		try {
			em.getTransaction().begin();
			em.remove(idAssertion);
			em.getTransaction().commit();
			
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			
			return null;
		}
	}

	@Override
	public Assertion AddFactToAssertion(Fact fact, Assertion assertion) {
		try {
			em.getTransaction().begin();
			assertion.getFacts().add(fact);
			em.persist(assertion);
			em.getTransaction().commit();
			return assertion;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

}
