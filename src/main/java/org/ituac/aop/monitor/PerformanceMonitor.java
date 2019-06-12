package org.ituac.aop.monitor;


public class PerformanceMonitor {
	
	private static ThreadLocal<MethodPerformance> performanceMonitor = 
			new ThreadLocal<MethodPerformance>();

	public static void begin(String method) {
		System.out.println("begin monitor...");
		MethodPerformance mp = new MethodPerformance(method);
		performanceMonitor.set(mp);
	}
	
	public static void end() {
		System.out.println("end monitor...");
		MethodPerformance mp = performanceMonitor.get();
		mp.PrintPerformance();
	}
	
}
