package cn.cjtblog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;
import cn.cjtblog.util.HibernateUtil;

/**
 *
 * @author cai
 */
public class SmokeDAOImpl implements SmokeDAO {
	private SessionFactory sessionFactory;
    @Override
    public void addSmoke(Smoke smoke) {
        Session session = sessionFactory.getCurrentSession();
        session.save(smoke);
      
    }

    @Override
    public List<Smoke> getAllSmokes() {
        Session session = sessionFactory.getCurrentSession();
        List<Smoke> smokeList  = session.createCriteria(Smoke.class).addOrder(Order.desc("reciveTime")).list();
        return smokeList;
    }

    @Override
    public void deleteSmoke(Smoke smoke) {
        Session session = sessionFactory.getCurrentSession();
         session.delete(smoke);
         

    }

    @Override
    public Smoke getNewestSmokeByNode(Node node) {
        Session session = sessionFactory.getCurrentSession();

        Smoke smoke = (Smoke) session.createCriteria(Smoke.class).add(Restrictions.eq("node", node)).
                    setMaxResults(1).uniqueResult();
 
 
        return smoke;
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Smoke getSmokeById(long id) {
		// TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        Smoke smoke=(Smoke) session.load(Smoke.class, id);
        return smoke;
	}
}
