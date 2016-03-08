package cn.cjtblog.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext applicationContext=getInitContext();
	public static <T> T getBean(Class<T> clz, String id){
		return applicationContext.getBean(id, clz);
	}
	public static Object getBean(String id){
		return applicationContext.getBean(id);
	}
	private static ApplicationContext getInitContext() {
		// TODO Auto-generated method stub
		ApplicationContext applicationContext=new ClassPathXmlApplicationContext("spring.xml");
		return applicationContext;
	}}
