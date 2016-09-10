package com.conflict.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.conflict.entities.Beh;

import com.conflict.services.BehaviorServices;

public class BehaviorDao implements BehaviorServices {

//	public static void main(String[] args) {
//
//		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
//		EntityManager em = emfactory.createEntityManager();
//		em.getTransaction().begin();
//		Beh beh = new Beh();
//		beh.setCont("helth pro");
//		beh.setPurp("location");
//		em.persist(beh);
//		em.getTransaction().commit();
//		em.close();
//		emfactory.close();
//	}

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
	EntityManager em = emfactory.createEntityManager();

	/**
	 * fonction pour ajouter une nouvelle behavior
	 */

	@Override
	public Beh get(Long id) {
		em.getTransaction().begin();
		Beh a = em.find(Beh.class, id);

		em.getTransaction().commit();
		return a;
	}

	@Override
	public Beh Add(Beh behavior) {

		try {
			em.getTransaction().begin();

			em.persist(behavior);

			em.getTransaction().commit();

			return behavior;
		} catch (Exception e) {
			em.getTransaction().rollback();

			return null;
		}
	}

	@Override
	public Beh Update(Beh behavior) {
		
		try {
			em.getTransaction().begin();
			em.merge(behavior);
			em.getTransaction().commit();
			return behavior;
		} catch (Exception e) {
			em.getTransaction().rollback();

			return null;
		}
	}

	@Override
	public List<Beh> getAll() {
		Query query = em.createQuery("SELECT a FROM com.conflict.entities.Beh a", Beh.class);
		List<Beh> a = query.getResultList();
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

}
