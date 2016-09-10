package com.conflict.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.conflict.entities.law;
import com.conflict.services.LawServices;



	import com.conflict.entities.Assertion;
	import com.conflict.entities.Beh;
import com.conflict.entities.Privacypolicy;

public class lawDao implements LawServices {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
		EntityManager em = emfactory.createEntityManager();

		/**
		 * fonction pour ajouter une nouvelle behavior
		 */

		@Override
		public law get(Long id) {
			em.getTransaction().begin();
			law a = em.find(law.class, id);
			
			em.getTransaction().commit();
			return a;
		}

		@Override
		public law Add(law law) {
			try {
				em.getTransaction().begin();
				em.persist(law);
				em.getTransaction().commit();

				return law;
			} catch (Exception e) {
				em.getTransaction().rollback();

				return null;
			}
		}

		@Override
		public law Update(law law) {
			
			try {
				em.getTransaction().begin();
				em.merge(law);
				em.getTransaction().commit();
			
				return law;
			} catch (Exception e) {
				em.getTransaction().rollback();
				
				return null;
			}
		}

		@Override
		public List<law> getAll() {
			Query query = em.createQuery("SELECT a FROM com.conflict.entities.law a", law.class);
			List<law> a = query.getResultList();
			return a;
		}

		@Override
		public Boolean delete(Long idlaw) {
			try {
				em.getTransaction().begin();
				em.remove(idlaw);
				em.getTransaction().commit();
				
				return true;
			} catch (Exception e) {
				em.getTransaction().rollback();
				
				return null;
			}
		}

		@Override
		public law AddPrivacyToLaw(Privacypolicy p, law l) {
			try {
				em.getTransaction().begin();
				l.setPrivacypolicy(p);
				em.getTransaction().commit();
				return l;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}
}
