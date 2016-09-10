package com.conflict.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.conflict.entities.Patient;
import com.conflict.entities.UserPref;
import com.conflict.services.PatientServices;

public class PatientDao implements PatientServices {

	EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("ConflictDetectionv1");
	EntityManager em = emfactory.createEntityManager();

	

	@Override
	public Patient get(Long id) {
		em.getTransaction().begin();
		Patient a = em.find(Patient.class, id);
		em.getTransaction().commit();
		return a;
	}

	@Override
	public Patient Add(Patient patient) {
		try {
			em.getTransaction().begin();
			em.persist(patient);
			em.getTransaction().commit();
			return patient;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public Patient Update(Patient patient) {
		
		try {
			em.getTransaction().begin();
			em.merge(patient);
			em.getTransaction().commit();
			return patient;
		} catch (Exception e) {
			em.getTransaction().rollback();

			return null;
		}
	}

	@Override
	public List<Patient> getAll() {
		Query query = em.createQuery("SELECT a FROM com.conflict.entities.Patient a", Patient.class);
		List<Patient> a = query.getResultList();
		return a;
	}

	@Override
	public Boolean delete(Long idPatient) {
		try {
			em.getTransaction().begin();
			em.remove(idPatient);
			em.getTransaction().commit();

			return true;
		} catch (Exception e) {
			em.getTransaction().rollback();

			return null;
		}
	}

	@Override
	public Patient addUserPrefToPatient(UserPref userPref, Patient patient) {
		try {
			em.getTransaction().begin();
			patient.setUserpref(userPref);
			em.persist(patient);
			em.getTransaction().commit();
			return patient;
		} catch (Exception e) {
			em.getTransaction().rollback();
			return null;
		}
	}

}
