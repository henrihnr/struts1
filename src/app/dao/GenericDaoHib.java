package app.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class GenericDaoHib<T, ID extends Serializable> implements GenericDao<T, ID> {

	@Autowired
	protected SessionFactory sessionFactory;
	
	public Class domainClass;
	
	public GenericDaoHib() {		
		this.domainClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public List<T> listAll() {
		return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName()).list();
	}
	
	public List<T> listAll(int offset, int pageSize) {
		return sessionFactory.getCurrentSession().createQuery("from " + domainClass.getName())
			.setFirstResult(offset)
			.setMaxResults(pageSize)
			.list();
	}
	
	public T findById(ID id) {
		return (T) sessionFactory.getCurrentSession().get(domainClass, id);
	}
	
	public T save(T domain) {
		sessionFactory.getCurrentSession().saveOrUpdate(domain);
		
		return domain;
	}
	
	public void delete(T domain) {
		sessionFactory.getCurrentSession().delete(domain);
	}
	
	public void delete(ID id) {
		delete(findById(id));
	}
	
}