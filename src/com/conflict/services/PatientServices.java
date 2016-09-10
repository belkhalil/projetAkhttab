package com.conflict.services;

import java.util.List;

import com.conflict.entities.Patient;
import com.conflict.entities.UserPref;

public interface PatientServices {
	public Patient get(Long id);
	public  Patient Add(Patient patient);
	public Patient Update(Patient patient);
	public List<Patient> getAll();
	public Boolean delete(Long idPtient);
	public Patient addUserPrefToPatient(UserPref userPref,Patient patient);
}
