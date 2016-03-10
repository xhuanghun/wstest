package cn.cjtblog.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.cjtblog.util.SpringUtil;

/**
 * Servlet implementation class InitNodeServlet
 */
@WebServlet(name="/InitSpringServlet",urlPatterns={"/InitSpringServlet"},loadOnStartup=1)
public class InitSpringServlet extends HttpServlet {
	private static Logger logger=LoggerFactory.getLogger(InitSpringServlet.class);
	// 初始化数据，方便测试
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
			ServletContext sc=config.getServletContext();
			ApplicationContext context=WebApplicationContextUtils.getRequiredWebApplicationContext(sc);
			SpringUtil.initContext(context);
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
