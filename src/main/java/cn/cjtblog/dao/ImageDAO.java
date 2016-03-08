package cn.cjtblog.dao;


import java.util.List;

import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Node;

public interface ImageDAO {
	public void addImage(Image image,byte[] bytes);
	public List<Image> getAllImages();
	public void deleteImage(Image image);
	public Image getNewestImageByNode(Node node);
	public void addImage(Image image);
	public Image getImageById(long id);
}
