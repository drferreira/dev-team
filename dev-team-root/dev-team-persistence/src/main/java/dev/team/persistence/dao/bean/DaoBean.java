package dev.team.persistence.dao.bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;

import dev.team.model.exceptions.DataNotFoundException;
import dev.team.persistence.dao.Dao;

@Stateless
public class DaoBean implements Dao{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void persist(Object entity) {
		entityManager.persist(entityManager.merge(entity));
	}

	@Override
	public void remove(Object entity) {
		entityManager.remove(entity);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Object> fetchResults(Criteria criteria) throws DataNotFoundException {
		List<Object> result = criteria.list();
		
		return (List<Object>) checkNullResult(result);
	}
	
	@Override
	public Object fetchResult(Criteria criteria) throws DataNotFoundException {
		Object result = criteria.uniqueResult();
		
		return checkNullResult(result);
	}

	@Override
	@SuppressWarnings("rawtypes")
	public Criteria getCriteria(Class entityTarget) {
		return getSession().createCriteria(entityTarget);
	}

	@Override
	public Session getSession() {
		return (Session) entityManager.getDelegate();
	}
	
	private Object checkNullResult(Object result) throws DataNotFoundException{
		if (result != null) {
			return result;
		}else {
			throw new DataNotFoundException();
		}
	}
	
}
