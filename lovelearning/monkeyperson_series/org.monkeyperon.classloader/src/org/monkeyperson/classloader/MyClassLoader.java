package org.monkeyperson.classloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.monkeyperson.appserver.AppServer;
import org.monkeyperson.appserver.AppServerInter;

/**
 * 类加载器
 * @author hesheng
 *
 */
public class MyClassLoader {

	public static void main(String[] args) throws Throwable {
			String rootPath = MyClassLoader.class.getResource("/").getPath();
			JarLoader.loadClasspath(rootPath);
			
			URL url = new URL("file://"+rootPath);   
			ClassLoader classLoader = new URLClassLoader( new URL[] {url} );   
			Thread.currentThread().setContextClassLoader(classLoader);
			
			String classQuanlityName = "org.monkeyperson.appserver.AppServer";
			AppServerInter asi = (AppServer) installObject(classLoader, classQuanlityName);
			asi.start();
			System.out.println("I am sleep 2 sec...");
			Thread.sleep(2*1000);
			//asi.stop();
	}

	@SuppressWarnings("unchecked")
	private static void callMethod(ClassLoader classLoader,String classQuanlityName,String methodName)throws ClassNotFoundException, NoSuchMethodException,IllegalAccessException, InvocationTargetException,InstantiationException {
		Class clazz = classLoader.loadClass(classQuanlityName);
		Method sayHiMethod = clazz.getMethod(methodName);
		sayHiMethod.invoke(clazz.newInstance());
	}
	
	@SuppressWarnings("unchecked")
	private static Object installObject(ClassLoader classLoader,String classQuanlityName)throws ClassNotFoundException, NoSuchMethodException,IllegalAccessException, InvocationTargetException,InstantiationException {
		Class clazz = classLoader.loadClass(classQuanlityName);
		return clazz.newInstance();
	}
}
