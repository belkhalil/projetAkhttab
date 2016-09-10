package com.conflict.dao;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.conflict.entities.HealthProvider;
import com.conflict.entities.Privacypolicy;
import com.conflict.services.HealthProviderServices;
public class HealthProviderDao implements HealthProviderServices {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
	EntityManager em = emfactory.createEntityManager();

	@Override
	public HealthProvider get(Long id) {
		em.getTransaction().begin();
		HealthProvider a = em.find(HealthProvider.class, id);
		em.getTransaction().commit();
		return a;
	}

	@Override
	public HealthProvider Add(HealthProvider healthProvider) {
		try {
			em.getTransaction().begin();
			em.persist(healthProvider);
			em.getTransaction().commit();
			return healthProvider;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public HealthProvider Update(HealthProvider healthProvider) {
		
		try {
			em.getTransaction().begin();
			em.merge(healthProvider);
			em.getTransaction().commit();
			return healthProvider;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public List<HealthProvider> getAll() {
		Query query = em.createQuery("SELECT a FROM com.conflict.entities.HealthProvider a", HealthProvider.class);
		List<HealthProvider> a = query.getResultList();
		return a;
	}

	@Override
	public Boolean delete(Long idHealthPro) {
		try {
			em.getTransaction().begin();
			em.remove(idHealthPro);
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	
	@Override
	public HealthProvider AddprivacyToHealthPro(HealthProvider h, Privacypolicy p) {
		try {
			em.getTransaction().begin();
		h.setPrivacypolicy(p);
		em.persist(h);
		em.getTransaction().commit();
		return h;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
		
	}


}
