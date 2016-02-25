package cn.cjtblog.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.cjtblog.service.NodeService;
import cn.cjtblog.service.SmokeService;
import cn.cjtblog.util.SpringUtil;

/**
 * Servlet implementation class InitNodeServlet
 */
@WebServlet(name="/InitNodeServlet",urlPatterns={"/initNodeServlet"},loadOnStartup=1)
public class InitNodeServlet extends HttpServlet {
	private static Logger logger=LoggerFactory.getLogger(InitNodeServlet.class);
	// 初始化数据
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		NodeService nodeService=(NodeService)SpringUtil.getBean("nodeService");
		logger.info(nodeService.getClass().toString()+":"+System.getProperty("IOTWebSocket.root"));
		if(nodeService.getAllNodes()!=null&&nodeService.getAllNodes().size()>0)
		{
			return;
		}
		for(int i=1;i<6;i++){
			Map<String,Object> fieldMap=new HashMap<>();
			fieldMap.put("nodeName", "node"+i);
			fieldMap.put("latitude", 120);
			fieldMap.put("longitude", 120);
			nodeService.addNode(fieldMap);
			logger.info("adding node"+"node"+i);
		}
	}

	private static final long serialVersionUID = 1L;
       


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
