package com.conflict.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.conflict.entities.Fact;
import com.conflict.entities.Query;
import com.conflict.services.QueryServices;

public class QueryDao implements QueryServices {
	
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
		EntityManager em = emfactory.createEntityManager();

		/**
		 * fonction pour ajouter une nouvelle behavior
		 */

		@Override
		public Query get(Long id) {
			em.getTransaction().begin();
			Query a = em.find(Query.class, id);
			em.getTransaction().commit();
			return a;
		}

		@Override
		public Query Add(Query query) {

			try {
				em.getTransaction().begin();
				em.persist(query);
				em.getTransaction().commit();
				return query;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

		@Override
		public Query Update(Query query) {
			try {
				em.getTransaction().begin();
				em.merge(query);
				em.getTransaction().commit();
				return query;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

		@Override
		public List<Query> getAll() {
			javax.persistence.Query query = em.createQuery("SELECT a FROM com.conflict.entities.Query a", Query.class);
			List<Query> a = query.getResultList();
			return a;
		}

		@Override
		public Boolean delete(Long idQuery) {
			try {
				em.getTransaction().begin();
				em.remove(idQuery);
				em.getTransaction().commit();
				return true;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

		@Override
		public Query AddFactToQuery(Fact fact, Query query) {
			try {
				em.getTransaction().begin();
				query.getFacts().add(fact);
				em.persist(query);
				em.getTransaction().commit();
				return query;
			} catch (Exception e) {
				em.getTransaction().rollback();
				return null;
			}
		}

	
}
