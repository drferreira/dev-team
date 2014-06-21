package dev.team.persistence.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import dev.team.model.exceptions.DataNotFoundException;

public interface Dao {
	
	public void persist(Object entity);
	
	public void remove(Object entity);
	
	@SuppressWarnings("rawtypes")
	public Criteria getCriteria(Class entityTarget);
	
	public Session getSession();
	
	public List<Object> fetchResults(Criteria criteria) throws DataNotFoundException;
	
	public Object fetchResult(Criteria criteria) throws DataNotFoundException;
}
