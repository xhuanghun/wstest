package cn.cjtblog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import cn.cjtblog.domain.Node;
import cn.cjtblog.util.HibernateUtil;

/**
 *
 * @author cai
 */
public class NodeDAOImpl implements NodeDAO {
	private SessionFactory sessionFactory;
    public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
    public void addNode(Node node) {
    	Session session=sessionFactory.getCurrentSession();
    	session.save(node);

    }
      @Override
    public void updateNode(Node node) {
      	Session session=sessionFactory.getCurrentSession();
        session.update(node);
    
    }

    @Override
    public List<Node> getAllNodes() {
    	Session session=sessionFactory.getCurrentSession();
        List<Node> nodeList = session.createCriteria(Node.class).list();
        return nodeList;
    }

    @Override
    public void deleteNode(Node node) {
    	Session session=sessionFactory.getCurrentSession();

        session.delete(node);


    }

    @Override
    public Node getNodeByNodeName(String nodeName) {
        String queryStr = "from Node WHERE NODENAME =:NODENAME";
        Session session=sessionFactory.getCurrentSession();
        Node node = (Node) session.createQuery(queryStr).setString("NODENAME", nodeName).uniqueResult();
        return node;
    }


}
