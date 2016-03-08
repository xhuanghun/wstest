package cn.cjtblog.service;

import java.util.Map;
import java.util.Set;

import cn.cjtblog.domain.Temperature;

public interface TemperatureService {

    public void addTemperature(String nodeName, String valueStr, String sendTimeStr);

    public Set<Temperature> getTemperatureByNodeName(String nodeName);
	public void addTemperature(Map<String, Object> fieldMap);

	public Temperature getTemperatureById(long id);

}
