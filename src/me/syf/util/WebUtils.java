package me.syf.util;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

public class WebUtils {

	public static <T> T request2Bean(HttpServletRequest request, Class<T> clazz) {
		try {
			T bean = clazz.newInstance();
			Enumeration<String> item = request.getParameterNames();
			System.out.println(item.hasMoreElements());
			while (item.hasMoreElements()) {
				String name = (String) item.nextElement();
				String value = request.getParameter(name);
				System.out.println("value="+value);
				BeanUtils.setProperty(bean, name, value);
				

			}
			return bean;
		} catch (InstantiationException e) {

			System.out.println("创建" + clazz + "实例失败");
			e.printStackTrace();
		} catch (IllegalAccessException e) {

			System.out.println("创建" + clazz + "实例失败");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println("封装到bean失败");
			e.printStackTrace();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return null;
	}

	public static String makeId() {
		return UUID.randomUUID().toString();
	}

}
