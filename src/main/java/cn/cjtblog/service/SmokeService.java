package cn.cjtblog.service;

import java.util.List;
import java.util.Map;

import cn.cjtblog.domain.Smoke;

/**
 *
 * @author cai
 */
public interface SmokeService {

    public void addSmoke(Long nodeId, String valueStr, String sendTimeStr);

    public List<Smoke> getSmokesByNode(Long nodeId);

	public void addSmoke(Map<String, Object> fieldMap);

	public Smoke getSmokeById(long id);

	// public void addSmoke(Node node,Map<String, Object> fieldMap);
}
