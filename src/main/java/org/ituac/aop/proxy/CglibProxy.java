package org.ituac.aop.proxy;

import java.lang.reflect.Method;

import org.ituac.aop.monitor.PerformanceMonitor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor {
	
	private Enhancer enhancer = new Enhancer();
	
	public Object getProxy(Class clazz) {
		enhancer.setSuperclass(clazz);
		enhancer.setCallback(this);
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy
			) throws Throwable {
		PerformanceMonitor.begin(obj.getClass().getName()+"."+method.getName());
		Object res = method.invoke(obj, args);
		PerformanceMonitor.end();
		return res;
	}

}
