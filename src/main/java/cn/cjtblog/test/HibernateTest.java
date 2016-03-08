package cn.cjtblog.test;

import java.util.HashMap;
import java.util.Map;

import cn.cjtblog.domain.Node;
import cn.cjtblog.domain.Smoke;
import cn.cjtblog.service.NodeService;
import cn.cjtblog.service.SmokeService;
import cn.cjtblog.util.SpringUtil;

public class HibernateTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeService nodeService=(NodeService)SpringUtil.getBean("nodeService");
		SmokeService smokeService=(SmokeService)SpringUtil.getBean("smokeService");

		System.out.println(nodeService.getClass());

		for(int i=1;i<6;i++){
			Map<String,Object> fieldMap=new HashMap<>();
			fieldMap.put("nodeName", "node"+i);
			fieldMap.put("latitude", 120);
			fieldMap.put("longitude", 120);
			nodeService.addNode(fieldMap);
		}
		



	}

}
