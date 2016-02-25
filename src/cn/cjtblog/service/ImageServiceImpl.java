package cn.cjtblog.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
    private  SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss:SSS");

    @Override
    public void addImage(String nodeName, byte[] bytes, String sendTimeStr) {
        Image image = new Image();
        Node node = nodeDAO.getNodeByNodeName(nodeName);
        if(node==null){
        	logger.warn("receive an unknow node: "+nodeName+" image");
        	return ;
        }
        Map<String, Object> fieldMap=new HashMap<>();
        fieldMap.put("node", node);
        fieldMap.put("sendTime", sendTimeStr);
        Date receiveTime =new Date();
        fieldMap.put("receiveTime",receiveTime);
        fieldMap.put("savePath", Image.SAVEIMAGEDIR+nodeName+"/" +receiveTime.getTime()+Image.SUFFIX);
        addImage(bytes,fieldMap);
    }
     public void addImage(byte[] bytes, Map<String, Object> fieldMap) {
    	 Image image=BeanUtil.createEntity(Image.class, fieldMap);
    	 imageDAO.addImage(image);
         String fileFullName = image.getSavePath();
         FileUtil.saveFile(fileFullName, bytes);
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
    public Set<Image> getImageByNodeName(String nodeName) {
        Node node = nodeDAO.getNodeByNodeName(nodeName);
        return node.getImages();
    }

	@Override
	public Image getImageById(long id) {
		// TODO Auto-generated method stub
		return imageDAO.getImageById(id);
	}
   
}
