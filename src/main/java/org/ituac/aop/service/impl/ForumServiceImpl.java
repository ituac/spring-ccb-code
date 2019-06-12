package org.ituac.aop.service.impl;

import org.ituac.aop.monitor.PerformanceMonitor;
import org.ituac.aop.service.ForumService;

public class ForumServiceImpl implements ForumService{

	@Override
	public void removeTopic(int topicId) {
		//开始监视
		//PerformanceMonitor.begin("org.ituac.aop.service.impl.ForumServiceImpl.removeTopic");
		System.out.println("模拟删除toptic记录:"+topicId);
		try {
			Thread.currentThread().sleep(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		//结束监视
		//PerformanceMonitor.end();
		
	}

	@Override
	public void removeForum(int forumId) {
		//开始监视
		//PerformanceMonitor.begin("org.ituac.aop.service.impl.ForumServiceImpl.removeForum");
		System.out.println("模拟删除forum记录:"+forumId);
		try {
			Thread.currentThread().sleep(16);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		//结束监视
		//PerformanceMonitor.end();
	}

}
