package cn.cjtblog.util;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.converters.DoubleConverter;

public class BeanUtil {
	static{
		
		DateConverter dateConverter=new DateConverter();
		dateConverter.setPattern("yyyy/MM/dd HH:mm:ss:SSS");
		ConvertUtils.register(dateConverter, Date.class);
		DoubleConverter doubleConverter=new DoubleConverter();
		doubleConverter.setPattern("0.#");
		ConvertUtils.register(doubleConverter, Double
				.class);
		
	}
    public static <T> T createEntity(Class<T> clz, Map<String, Object> fieldMap) {
    	T bean = null;
    	try {
			bean = clz.newInstance();
        for (String fieldName : fieldMap.keySet()) {

				BeanUtils.setProperty(bean, fieldName, fieldMap.get(fieldName));
			
        }
    	}
    	catch (InstantiationException|IllegalAccessException|InvocationTargetException e) {

			return null;
		}
    	return bean;
    }
    public static <T> boolean updateEntity(T bean,Map<String, Object> fieldMap){
    	try {

        for (String fieldName : fieldMap.keySet()) {

				BeanUtils.setProperty(bean, fieldName, fieldMap.get(fieldName));
			
        }
    	}
    	catch (IllegalAccessException|InvocationTargetException e) {

			return false;
		}
    	return true;
    }
}
