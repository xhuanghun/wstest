package cn.cjtblog.service;

import java.util.List;
import java.util.Map;

import cn.cjtblog.domain.Node;

public interface NodeService {
	void addNode(Node node);
	List<Node> getAllNodes();
	void addNode(Map<String, Object> fieldMap);
	Node getNodeById(Long nodeId);
	void updateNode(Node node);
}
