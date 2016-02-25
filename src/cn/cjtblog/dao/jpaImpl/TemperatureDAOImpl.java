package cn.cjtblog.dao.jpaImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.cjtblog.dao.TemperatureDAO;
import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;
import cn.cjtblog.domain.Temperature;

/**
 *
 * @author cai
 */
public class TemperatureDAOImpl implements TemperatureDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
    public void addTemperature(Temperature temperature) {  
    	entityManager.persist(temperature);
    }

    @Override
    public List<Temperature> getAllTemperatures() {
        // String query="from T_Temperature";
        List<Temperature> temperatureList = entityManager.createQuery("from Temperature",Temperature.class).getResultList();
        return temperatureList;
    }

    @Override
    public void deleteTemperature(Temperature temperature) {
    	entityManager.remove(temperature);
    
    }

    @Override
    public Temperature getNewestTempertuareByNode(Node node) {
            String queryStr="SELECT distinct temperature FROM Temperature temperature where temperature.node.id=:id ORDER BY temperature.receiveTime desc";
        	Query query=entityManager.createQuery(queryStr);
        	query.setParameter("id", node.getId());
        	Temperature temperature=(Temperature)query.getSingleResult();

        return temperature;
    }

	@Override
	public Temperature getTemmperatureById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Temperature.class, id);
	}

}
