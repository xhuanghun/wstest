package cn.cjtblog.dao.jpaImpl;

import java.util.List;

import cn.cjtblog.domain.Node;

public class BaseSensorDataDAOImpl<T> extends BaseEntityDAOImpl<T> {


	public T getNewestByNode(Node node) {
		String queryStr = "FROM "
				+ entityClass.getSimpleName()
				+ " t WHERE t.sensor.node.id=:nodeId ORDER BY t.sendTime DESC";
		List result = entityManager.createQuery(queryStr)
				.setParameter("nodeId", node.getId()).setMaxResults(1)
				.getResultList();
		if (result.size() > 0) {
			return (T) result.get(0);
		} else {
			return null;
		}
	}
	
	public List<T> getAllByNode(Node node) {
		String queryStr = "FROM "
				+ entityClass.getSimpleName()
				+ " t WHERE t.sensor.node.id=:nodeId ORDER BY t.sendTime DESC";
		List<T> result = entityManager.createQuery(queryStr)
				.setParameter("nodeId", node.getId()).getResultList();
		return result;
		
	}

}
