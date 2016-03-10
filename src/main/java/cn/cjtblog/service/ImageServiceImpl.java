package cn.cjtblog.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.cjtblog.dao.ImageDAO;
import cn.cjtblog.dao.NodeDAO;
import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Node;
import cn.cjtblog.util.BeanUtil;
import cn.cjtblog.util.FileUtil;

/**
 *
 * @author cai
 */
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class ImageServiceImpl implements ImageService {

   
	private static Logger logger=LoggerFactory.getLogger(ImageServiceImpl.class);
    private ImageDAO imageDAO;
    private NodeDAO nodeDAO;


    @Override
    public void addImage(Long nodeId, byte[] bytes, String sendTimeStr) {
        Node node = nodeDAO.getById(nodeId);
        if(node==null){
        	logger.warn("receive an unknow node: nodeId="+nodeId+" image");
        	return ;
        }
        Map<String, Object> fieldMap=new HashMap<>();
        fieldMap.put("node", node);
        fieldMap.put("sendTime", sendTimeStr);
        Date receiveTime =new Date();
        fieldMap.put("receiveTime",receiveTime);
        String URL=Image.IMAGEBASICURL+nodeId+"/" +receiveTime.getTime()+Image.SUFFIX;
        fieldMap.put("URL", URL);
        FileUtil.saveFile(Image.SAVEIMAGEDIR+URL, bytes);
        addImage(fieldMap);
    }
     public void addImage( Map<String, Object> fieldMap) {
    	 Image image=BeanUtil.createEntity(Image.class, fieldMap);
    	 imageDAO.add(image);
	}
	public ImageDAO getImageDAO() {
		return imageDAO;
	}
	public void setImageDAO(ImageDAO imageDAO) {
		this.imageDAO = imageDAO;
	}
	public NodeDAO getNodeDAO() {
		return nodeDAO;
	}
	public void setNodeDAO(NodeDAO nodeDAO) {
		this.nodeDAO = nodeDAO;
	}
	@Override
	@Transactional(propagation=Propagation.REQUIRED,readOnly=true)
    public List<Image> getImageByNodeId(Long nodeId) {
        Node node = nodeDAO.getById(nodeId);
        return imageDAO.getAllByNode(node);
    }

	@Override
	public Image getImageById(long id) {
		// TODO Auto-generated method stub
		return imageDAO.getById(id);
	}

   
}
