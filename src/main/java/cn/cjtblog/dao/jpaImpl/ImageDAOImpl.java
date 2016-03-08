package cn.cjtblog.dao.jpaImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.criterion.Restrictions;

import cn.cjtblog.dao.ImageDAO;
import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Node;
import cn.cjtblog.util.FileUtil;

/**
 *
 * @author cai
 */
public class ImageDAOImpl implements ImageDAO {
	@PersistenceContext
	private EntityManager entityManager;

	@Override
    public void addImage(Image image, byte[] bytes) {
        String fileFullName = image.getSavePath();
        FileUtil.saveFile(fileFullName, bytes);
        entityManager.persist(image);
    }
	@Override
	public void addImage(Image image) {
		// TODO Auto-generated method stub
		 entityManager.persist(image);
	}
    @Override
    public List<Image> getAllImages() {
        List<Image> allImages =entityManager.createQuery( "from Image",Image.class ).getResultList();
        return allImages;
    }

    @Override
    public void deleteImage(Image image) {
        entityManager.remove(image);

    }

    @Override
    public Image getNewestImageByNode(Node node) {
        String queryStr="SELECT distinct image FROM Image image where image.node.id=:id ORDER BY image.receiveTime desc";
    	Query query=entityManager.createQuery(queryStr);
    	query.setParameter("id", node.getId());
        Image image=(Image)query.getSingleResult();
        return image;
    }
	@Override
	public Image getImageById(long id) {
		// TODO Auto-generated method stub
		return entityManager.find(Image.class, id);
	}





}
