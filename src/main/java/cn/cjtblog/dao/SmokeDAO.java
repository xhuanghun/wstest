package cn.cjtblog.dao;

import java.util.List;

import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;

/**
 *
 * @author cai
 */
public interface SmokeDAO {

    public void add(Smoke smoke);

    public List<Smoke> getAll();

    public void delete(Smoke smoke);

    public Smoke getNewestByNode(Node node);

	public Smoke getById(long id);
	public List<Smoke> getAllByNode(Node node);
}
