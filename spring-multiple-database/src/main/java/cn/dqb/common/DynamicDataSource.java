package cn.dqb.common;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

public class DynamicDataSource extends AbstractRoutingDataSource {
	public static final String dataSource1 = "dataSource1";
	public static final String dataSource2 = "dataSource2";

	private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

	public static void setDataSourceKey(String dataSource) {
		contextHolder.set(dataSource);
	}

	@Override
	protected Object determineCurrentLookupKey() {
		String name = contextHolder.get();
		// 获取完后解除绑定，防止其他的service方法调用该数据源
		contextHolder.remove();
		return name;
	}
}
