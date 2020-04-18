//package cn.dqb.aop;
//
//public aspect MyAspectJDemo {
//	//定义切点，日志
//	pointcut recordLog(): call( * cn.dqb.service.*.*(..));
//
//	// 定义切点，权限
//	pointcut authCheck(): call( * cn.dqb.service.*.*(..));
//
//	// 定义切点，返回值
//	pointcut getResult(): call( * cn.dqb.service.*.*(..));
//
//	// 定义切点，异常返回
//	pointcut getException(): call( * cn.dqb.service.*.*(..));
//
//	//定义切点，环绕通知
//	pointcut aroundAdvice(): call( * cn.dqb.service.*.*(..));
//
//	/**
//	 * 定义前置通知
//	 */
//	before(): authCheck() {
//		System.out.println("方法调用前，权限检查");
//	}
//	/**
//	 * 定义后置通知
//	 */
//	after(): recordLog() {
//		System.out.println("方法调用后，记录日志");
//	}
//
//	/**
//	 * 定义后置通知带返回值
//	 * after(参数)returning(返回值类型):连接点函数{
//	 *     函数体
//	 * }
//	 */
//	after()returning(Object x): getResult(){
//		System.out.println("返回值为:" + x);
//	}
//
//
//	/**
//	 * 异常通知
//	 * after(参数) throwing(返回值类型):连接点函数{
//	 *     函数体
//	 * }
//	 */
//	after() throwing(Exception e):getException(){
//		System.out.println("抛出异常:" + e.toString());
//	}
//
//	/**
//	 * 环绕通知 可通过proceed()控制目标函数是否执行
//	 * Object around(参数):连接点函数{
//	 *     函数体
//	 *     Object result=proceed();//执行目标函数
//	 *     return result;
//	 * }
//	 */
//
////	Object around():aroundAdvice(){
////		System.out.println("getUsername 执行前执行");
////		Object result = proceed();//执行目标函数
////		System.out.println("getUsername 执行后执行");
////		return result;
////	}
//}