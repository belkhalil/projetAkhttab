package com.conflict.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.conflict.entities.Assertion;
import com.conflict.entities.Privacypolicy;
import com.conflict.services.PrivacyPolicyServices;

public class PrivacyPolicyDao implements PrivacyPolicyServices {

		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
		EntityManager em = emfactory.createEntityManager();

		/**
		 * fonction pour ajouter une nouvelle behavior
		 */

		@Override
		public Privacypolicy get(Long id) {
			em.getTransaction().begin();
			Privacypolicy a = em.find(Privacypolicy.class, id);
			em.close();
//			emfactory.close();
//			em.getTransaction().commit();
			return a;
		}

		@Override
		public Privacypolicy Add(Privacypolicy privacypolicy) {

			try {
				em.getTransaction().begin();
				em.persist(privacypolicy);
				em.getTransaction().commit();
//				em.close();
//				emfactory.close();
				return privacypolicy;
			} catch (Exception e) {
				em.getTransaction().rollback();
				em.close();
				emfactory.close();
				return null;
			}
		}

		@Override
		public Privacypolicy Update(Privacypolicy privacypolicy) {
			
			try {
				em.getTransaction().begin();
				em.merge(privacypolicy);
				em.getTransaction().commit();
				return privacypolicy;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

		@Override
		public List<Privacypolicy> getAll() {
			Query query = em.createQuery("SELECT a FROM com.conflict.entities.Privacypolicy a", Privacypolicy.class);
			List<Privacypolicy> a = query.getResultList();
			return a;
		}

		@Override
		public Boolean delete(Long idPrivacy) {
			try {
				em.getTransaction().begin();
				em.remove(idPrivacy);
				em.getTransaction().commit();
//				em.close();
				return true;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

		@Override
		public Privacypolicy AddQueryToPrivacy(com.conflict.entities.Query query, Privacypolicy privacypolicy) {
			try {
				em.getTransaction().begin();
				privacypolicy.getQueries().add(query);
				em.persist(privacypolicy);
				em.getTransaction().commit();
				return privacypolicy;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

		@Override
		public Privacypolicy AddAssertionToPrivacy(Assertion assertion, Privacypolicy privacypolicy) {
			try {
				em.getTransaction().begin();
				privacypolicy.getAssertions().add(assertion);
				em.persist(privacypolicy);
				em.getTransaction().commit();
				return privacypolicy;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

	
}
