package cn.cjtblog.dao;

import java.util.List;

import cn.cjtblog.domain.Node;

/**
 *
 * @author cai
 */
public interface NodeDAO {
    	public void addNode(Node node);
        public void updateNode(Node node);
        public Node getNodeByNodeName(String nodeName);
	public List<Node> getAllNodes();
	public void deleteNode(Node node);
        
}
