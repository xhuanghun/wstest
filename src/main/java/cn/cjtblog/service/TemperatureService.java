package cn.cjtblog.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import cn.cjtblog.domain.Temperature;

public interface TemperatureService {

    public void addTemperature(Long nodeId, String valueStr, String sendTimeStr);

    public List<Temperature> getTemperaturesByNode(Long nodeId);
	public void addTemperature(Map<String, Object> fieldMap);

	public Temperature getTemperatureById(long id);

}
