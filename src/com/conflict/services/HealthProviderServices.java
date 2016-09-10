package com.conflict.services;

import java.util.List;


import com.conflict.entities.HealthProvider;
import com.conflict.entities.Privacypolicy;

public interface HealthProviderServices {
	public HealthProvider get(Long id);
	public  HealthProvider Add(HealthProvider healthProvider);
	public HealthProvider Update(HealthProvider healthProvider);
	public List<HealthProvider> getAll();
	public Boolean delete(Long idHealthPro);
	public HealthProvider AddprivacyToHealthPro(HealthProvider h,Privacypolicy p);
}
