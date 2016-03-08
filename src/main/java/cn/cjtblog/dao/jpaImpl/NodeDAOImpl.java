package cn.cjtblog.dao.jpaImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

import cn.cjtblog.dao.NodeDAO;
import cn.cjtblog.domain.Node;

/**
 *
 * @author cai
 */
public class NodeDAOImpl implements NodeDAO {

	@PersistenceContext
	private EntityManager entityManager;
    public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	@Override
    public void addNode(Node node) {
		entityManager.persist(node);


    }
      @Override
    public void updateNode(Node node) {
          entityManager.merge(node);
    
    }

    @Override
    public List<Node> getAllNodes() {
        List<Node> nodeList = entityManager.createQuery("from Node",Node.class).getResultList();
        return nodeList;
    }

    @Override
    public void deleteNode(Node node) {
        entityManager.remove(node);


    }

    @Override
    public Node getNodeByNodeName(String nodeName) {
        String queryStr = "from Node node WHERE node.nodeName =:nodeName";
        Node node = (Node) entityManager.createQuery(queryStr).setParameter("nodeName", nodeName).getResultList().get(0);
        return node;
    }


}
