package cn.cjtblog.service;

import java.util.Map;
import java.util.Set;

import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Temperature;

public interface ImageService {
	public void addImage(String nodeId,byte[] bytes,String sendTimeStr);
    public Set<Image> getImageByNodeName(String nodeName);

	public void addImage(byte[] bytes,Map<String, Object> fieldMap);

	public Image getImageById(long id);
}
