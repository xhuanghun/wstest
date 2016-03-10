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
import cn.cjtblog.domain.Temperature;
import cn.cjtblog.util.FileUtil;

/**
 *
 * @author cai
 */
public class ImageDAOImpl extends BaseSensorDataDAOImpl<Image>  implements ImageDAO {


}
