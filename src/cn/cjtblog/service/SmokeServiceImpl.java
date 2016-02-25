package cn.cjtblog.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cjtblog.dao.NodeDAO;
import cn.cjtblog.dao.NodeDAOImpl;
import cn.cjtblog.dao.SmokeDAO;
import cn.cjtblog.dao.SmokeDAOImpl;
import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;
import cn.cjtblog.util.BeanUtil;

@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class SmokeServiceImpl implements SmokeService {

    private SmokeDAO smokeDAO ;
    private NodeDAO nodeDAO ;
    public SmokeDAO getSmokeDAO() {
		return smokeDAO;
	}

	public void setSmokeDAO(SmokeDAO smokeDAO) {
		this.smokeDAO = smokeDAO;
	}

	public NodeDAO getNodeDAO() {
		return nodeDAO;
	}

	public void setNodeDAO(NodeDAO nodeDAO) {
		this.nodeDAO = nodeDAO;
	}



    @Override
    public void addSmoke(String nodeName, String valueStr, String sendTimeStr) {
        Node node = nodeDAO.getNodeByNodeName(nodeName);
        Map<String, Object> fieldMap=new HashMap<>();
        fieldMap.put("node", node);
        fieldMap.put("receiveTime",new Date());
        fieldMap.put("sendTime", sendTimeStr);
        fieldMap.put("value", valueStr);
        addSmoke(fieldMap);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public Set<Smoke> getSmokeByNodeName(String nodeName) {
        Node node = nodeDAO.getNodeByNodeName(nodeName);
        return node.getSmokes();
    }

	@Override
	public void addSmoke(Map<String, Object> fieldMap) {
		Smoke smoke=BeanUtil.createEntity(Smoke.class, fieldMap);
		smokeDAO.addSmoke(smoke);		
	}

	@Override
    @Transactional(propagation=Propagation.REQUIRED,readOnly=true)
	public Smoke getSmokeById(long id) {
		// TODO Auto-generated method stub
		return smokeDAO.getSmokeById(id);
	}

}
