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

import cn.cjtblog.dao.SmokeDAO;
import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;

/**
 *
 * @author cai
 */
public class SmokeDAOImpl implements SmokeDAO {
	@PersistenceContext
	private EntityManager entityManager;
	
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
    public void addSmoke(Smoke smoke) {

        entityManager.persist(smoke);
      
    }

    @Override
    public List<Smoke> getAllSmokes() {
 
        List<Smoke> smokeList = entityManager.createQuery("from Smoke",Smoke.class).getResultList();
        return smokeList;
    }

    @Override
    public void deleteSmoke(Smoke smoke) {

        entityManager.remove(smoke);

    }

    @Override
    public Smoke getNewestSmokeByNode(Node node) {
        String queryStr="SELECT distinct smoke FROM Smoke smoke where smoke.node.id=:id ORDER BY smoke.receiveTime desc";
    	Query query=entityManager.createQuery(queryStr);
    	query.setParameter("id", node.getId());
        Smoke smoke=(Smoke)query.getSingleResult();
        return smoke;
    }

	@Override
	public Smoke getSmokeById(long id) {
		// TODO Auto-generated method stub
		
		return entityManager.find(Smoke.class, id);
	}

}
