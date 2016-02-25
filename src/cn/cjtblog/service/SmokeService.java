package cn.cjtblog.service;

import java.util.Map;
import java.util.Set;

import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;

/**
 *
 * @author cai
 */
public interface SmokeService {

    public void addSmoke(String nodeName, String valueStr, String sendTimeStr);

    public Set<Smoke> getSmokeByNodeName(String nodeName);

	public void addSmoke(Map<String, Object> fieldMap);

	public Smoke getSmokeById(long id);

	// public void addSmoke(Node node,Map<String, Object> fieldMap);
}
