package cn.cjtblog.dao;

import java.util.List;

import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;

/**
 *
 * @author cai
 */
public interface SmokeDAO {

    public void addSmoke(Smoke smoke);

    public List<Smoke> getAllSmokes();

    public void deleteSmoke(Smoke smoke);

    public Smoke getNewestSmokeByNode(Node node);

	public Smoke getSmokeById(long id);
}
