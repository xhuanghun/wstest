package cn.cjtblog.dao;

import java.util.List;

import cn.cjtblog.domain.Node;

/**
 *
 * @author cai
 */
public interface NodeDAO {
    	public void add(Node node);
        public void update(Node node);
        public Node getById(long id);
	public List<Node> getAll();
	public void delete(Node node);
}
