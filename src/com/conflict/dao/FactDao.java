package com.conflict.dao;

import java.awt.TrayIcon;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.conflict.entities.Beh;
import com.conflict.entities.Fact;
import com.conflict.services.FactServices;

public class FactDao implements FactServices {

	
	
		  public static void main(String[] args) {
		  
		  EntityManagerFactory emfactory=
		  Persistence.createEntityManagerFactory("ConflictDetectionv1"); EntityManager
		  em= emfactory.createEntityManager();
		  em.getTransaction().begin();
		  Fact fact = new Fact();
		  fact.setContenu("helth pro");
		  em.persist(fact);
		  em.getTransaction().commit(); 
		  em.close(); emfactory.close(); }
		
	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
	EntityManager em = emfactory.createEntityManager();

	/**
	 * fonction pour ajouter une nouvelle behavior
	 */

	@Override
	public Fact get(Long id) {
		em.getTransaction().begin();
		Fact a = em.find(Fact.class, id);
		em.getTransaction().commit();
		return a;
	}

	@Override
	public Fact Add(Fact fact) {

		try {
			em.getTransaction().begin();
			em.persist(fact);
			em.getTransaction().commit();
			return fact;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public Fact Update( Fact fact) {
		
		try {
			em.getTransaction().begin();
			em.merge(fact);
			em.getTransaction().commit();
			return fact;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public List<Fact> getAll() {
		Query query = em.createQuery("SELECT a FROM com.conflict.entities.Behavior a", Fact.class);
		List<Fact> a = query.getResultList();
		return a;
	}

	@Override
	public Boolean delete(Long idBehavior) {
		try {
			em.getTransaction().begin();
			em.remove(idBehavior);
			em.getTransaction().commit();

			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();

			return null;
		}
	}

	@Override
	public Fact addBehaviorToFact(Beh beh, Fact fact) {
		try {
			em.getTransaction().begin();
			fact.setBehavior(beh);
			em.persist(fact);
			em.getTransaction().commit();
			return fact;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

}
