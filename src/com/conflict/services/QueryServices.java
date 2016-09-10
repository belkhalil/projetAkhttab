package com.conflict.services;

import java.util.List;

import com.conflict.entities.Fact;
import com.conflict.entities.Query;

public interface QueryServices {
	public Query get(Long id);
	public  Query Add(Query query);
	public Query Update(Query query);
	public List<Query> getAll();
	public Boolean delete(Long idQuery);
	public Query AddFactToQuery(Fact fact, Query query);
}
