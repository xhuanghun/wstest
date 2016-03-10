package cn.cjtblog.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtil {
	private static ApplicationContext applicationContext;
	public static <T> T getBean(Class<T> clz, String id){
		return applicationContext.getBean(id, clz);
	}
	public static Object getBean(String id){
		return applicationContext.getBean(id);
	}
	public static void initContext(ApplicationContext context) {
		// TODO Auto-generated method stub
		applicationContext=context;
	}}
