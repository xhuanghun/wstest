package cn.cjtblog.service;

import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cjtblog.dao.NodeDAO;
import cn.cjtblog.domain.Node;
import cn.cjtblog.util.BeanUtil;
import cn.cjtblog.util.FileUtil;
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class NodeServiceImpl implements NodeService {
	private NodeDAO nodeDAO;

	public NodeDAO getNodeDAO() {
		return nodeDAO;
	}

	public void setNodeDAO(NodeDAO nodeDAO) {
		this.nodeDAO = nodeDAO;
	}
	@Override
	public void addNode(Node node) {
        FileUtil.makeDir(node.getId());
		nodeDAO.add(node);
		
	}

	@Override
	public void addNode(Map<String, Object> fieldMap) {
		Node node=BeanUtil.createEntity(Node.class, fieldMap);
        FileUtil.makeDir(node.getId());
		nodeDAO.add(node);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public List<Node> getAllNodes() {
		// TODO Auto-generated method stub
		return nodeDAO.getAll();
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Node getNodeById(Long nodeId) {
		// TODO Auto-generated method stub
		return nodeDAO.getById(nodeId);
	}

	@Override
	public void updateNode(Node node) {
		// TODO Auto-generated method stub
		nodeDAO.update(node);
	}

}
