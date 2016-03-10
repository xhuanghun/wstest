package cn.cjtblog.service;

import java.util.List;
import java.util.Map;

import cn.cjtblog.domain.Image;

public interface ImageService {
	public void addImage(Long nodeId,byte[] bytes,String sendTimeStr);
    public List<Image> getImageByNodeId(Long nodeId);

	public Image getImageById(long id);
}
