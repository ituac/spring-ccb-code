package org.ituac;

import java.lang.reflect.Proxy;

import org.ituac.aop.handler.PerformanceHandler;
import org.ituac.aop.proxy.CglibProxy;
import org.ituac.aop.service.ForumService;
import org.ituac.aop.service.impl.ForumServiceImpl;
import org.junit.Test;

public class ForumTest {
	
	public static void main(String[] args) {
		
//		ForumServiceImpl forumServiceImpl = new ForumServiceImpl();
//		forumServiceImpl.removeForum(29);
		
	}
	
	@Test
	public void proxy() {
		
		ForumServiceImpl target = new ForumServiceImpl();
		PerformanceHandler performanceHandler = new PerformanceHandler(target);
		ForumService forumService = (ForumService) Proxy.newProxyInstance(target.getClass().getClassLoader()
				, target.getClass().getInterfaces(), performanceHandler);
		forumService.removeForum(29);
	}
	
	@Test
	public void cglibProxy() {
		
		CglibProxy cglibProxy = new CglibProxy();
		ForumServiceImpl proxy = (ForumServiceImpl) cglibProxy.getProxy(ForumServiceImpl.class);
		proxy.removeForum(29);
	}

}
