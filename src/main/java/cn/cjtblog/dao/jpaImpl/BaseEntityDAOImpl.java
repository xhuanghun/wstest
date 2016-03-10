package cn.cjtblog.dao.jpaImpl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

public abstract class BaseEntityDAOImpl<T> {

	protected Class<T> entityClass;  
	@PersistenceContext
	protected EntityManager entityManager;
    public  BaseEntityDAOImpl() {  
        Type genType = getClass().getGenericSuperclass();  
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();  
        entityClass = (Class) params[0];  
    }  

    public EntityManager getEntityManager(){
    	return entityManager;
    }
    public void setEntityManager(EntityManager entityManager){
    	this.entityManager=entityManager;
    }

	public void add(T t){
		entityManager.persist(t);
	}
    public void update(T t){
    	entityManager.merge(t);
    }
    public T getById(long id){
    	return entityManager.find(entityClass, id);
    }
	public void deleteById(long id){
		T t=getById(id);
		if(t!=null){
			entityManager.remove(t);
		}
	}
	public void delete(T t){
		entityManager.remove(t);
	}
	
	public List<T> getAll(){
		return (List<T>)getEntityManager().createQuery("from "+entityClass.getSimpleName()).getResultList();
	}
	
}
