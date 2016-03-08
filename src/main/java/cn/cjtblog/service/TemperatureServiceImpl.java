package cn.cjtblog.service;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cjtblog.dao.NodeDAO;
import cn.cjtblog.dao.TemperatureDAO;
import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Temperature;
import cn.cjtblog.util.BeanUtil;

@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class TemperatureServiceImpl implements TemperatureService {
	private static Logger log = LoggerFactory.getLogger(TemperatureServiceImpl.class);
    private TemperatureDAO temperatureDAO ;
    private NodeDAO nodeDAO ;
    public TemperatureDAO getTemperatureDAO() {
		return temperatureDAO;
	}

	public void setTemperatureDAO(TemperatureDAO temperatureDAO) {
		this.temperatureDAO = temperatureDAO;
	}

	public NodeDAO getNodeDAO() {
		return nodeDAO;
	}

	public void setNodeDAO(NodeDAO nodeDAO) {
		this.nodeDAO = nodeDAO;
	}



    @Override
    public void addTemperature(String nodeName, String valueStr, String sendTimeStr) {
        Node node = nodeDAO.getNodeByNodeName(nodeName);     
        Map<String,Object> fieldMap=new HashMap<>();
        fieldMap.put("node", node);
        fieldMap.put("receiveTime", new Date());
        fieldMap.put("value", valueStr);
        fieldMap.put("sendTime", sendTimeStr);
        addTemperature(fieldMap);



    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public Set<Temperature> getTemperatureByNodeName(String nodeName) {
        Node node = nodeDAO.getNodeByNodeName(nodeName);
        return node.getTemperatures();
    }

	@Override
	public void addTemperature(Map<String, Object> fieldMap) {
		Temperature temperature=BeanUtil.createEntity(Temperature.class, fieldMap);
		temperatureDAO.addTemperature(temperature);
		
	}

	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Temperature getTemperatureById(long id) {
		// TODO Auto-generated method stub
		return temperatureDAO.getTemmperatureById(id);
	}

}
