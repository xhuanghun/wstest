package cn.cjtblog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Temperature;
import cn.cjtblog.util.HibernateUtil;

/**
 *
 * @author cai
 */
public class TemperatureDAOImpl implements TemperatureDAO {
	private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
    public void addTemperature(Temperature temperature) {
        Session session = sessionFactory.getCurrentSession();   
            session.save(temperature);
    }

    @Override
    public List<Temperature> getAllTemperatures() {
        // String query="from T_Temperature";
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        List<Temperature> temperatureList = null;
        try {
            tx = session.beginTransaction();
            temperatureList = session.createCriteria(Temperature.class).addOrder(Order.desc("receiveTime")).list();
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
        	if (tx != null) {
                tx.rollback();
            }
            temperatureList=new ArrayList<>();
        }

        return temperatureList;
    }

    @Override
    public void deleteTemperature(Temperature temperature) {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(temperature);
            tx.commit();
        } catch (Exception e) {
        	e.printStackTrace();
            if (tx != null) {
                tx.rollback();
            }
        }
     
    }

    @Override
    public Temperature getNewestTempertuareByNode(Node node) {
        Session session = sessionFactory.getCurrentSession();
        Temperature temperature = (Temperature) session.createCriteria(Temperature.class).add(Restrictions.eq("node", node)).
                    setMaxResults(1).addOrder(Order.desc("receiveTime")).uniqueResult();
    

        return temperature;
    }

	@Override
	public Temperature getTemmperatureById(long id) {
		// TODO Auto-generated method stub
        Session session = sessionFactory.getCurrentSession();
        return (Temperature)session.load(Temperature.class, id);
	}

}
