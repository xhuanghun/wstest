package cn.cjtblog.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import cn.cjtblog.domain.Image;
import cn.cjtblog.domain.Node;
import cn.cjtblog.util.FileUtil;

/**
 *
 * @author cai
 */
public class ImageDAOImpl implements ImageDAO {
	private SessionFactory sessionFactory;
    @Override
    public void addImage(Image image, byte[] bytes) {
        String fileFullName = image.getSavePath();
        FileUtil.saveFile(fileFullName, bytes);
        Session session = sessionFactory.getCurrentSession();
        session.save(image);
    }
	@Override
	public void addImage(Image image) {

        Session session = sessionFactory.getCurrentSession();
        session.save(image);
	}
    @Override
    public List<Image> getAllImages() {
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = null;
        List<Image> allImages = session.createQuery("From image").list();

        return allImages;
    }

    @Override
    public void deleteImage(Image image) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(image);
   

    }

    @Override
    public Image getNewestImageByNode(Node node) {
        //String sqlStr="select * from T_IMAGE where order by receiveTime desc fetch first row only";
        String sqlStr = "from Image where node.nodeName=:nodeName order by receiveTime desc";
        Session session = sessionFactory.getCurrentSession();
        Image image= (Image) session.createCriteria(Image.class).add(Restrictions.eq("node", node)).
                    setMaxResults(1).uniqueResult();
        return image;
    }

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public Image getImageById(long id) {
        Session session = sessionFactory.getCurrentSession();
		return (Image)session.load(Image.class, id);
	}



}
