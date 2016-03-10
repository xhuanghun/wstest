package cn.cjtblog.test;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import cn.cjtblog.dao.jpaImpl.NodeDAOImpl;
import cn.cjtblog.domain.Node;
import cn.cjtblog.util.BeanUtil;

public class JPATest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory	entityManagerFactory = Persistence.createEntityManagerFactory( "test" );
		NodeDAOImpl nodeDAO=new NodeDAOImpl();
	
		for(int i=0;i<5;i++){
			Map<String,Object> fieldMap=new HashMap<>();
			fieldMap.put("nodeName", "node"+i);
			fieldMap.put("latitude", 120);
			fieldMap.put("longtitude", 120);
			nodeDAO.add(BeanUtil.createEntity(Node.class, fieldMap));
			System.out.println("adding");
		}

	}

}
