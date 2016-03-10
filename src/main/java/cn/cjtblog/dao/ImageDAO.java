package cn.cjtblog.dao;


import java.util.List;

import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Node;

public interface ImageDAO {
	public void add(Image image);
	public List<Image> getAll();
	public void delete(Image image);
	public Image getNewestByNode(Node node);
	public Image getById(long id);
	public List<Image> getAllByNode(Node node);
}
