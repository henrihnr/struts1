package app.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
	
	public List<T> listAll();
	public List<T> listAll(int offset, int pageSize);
	
	public T findById(ID id);
	
	public T save(T domain);
	
	public void delete(T domain);
	public void delete(ID id);
	
}
