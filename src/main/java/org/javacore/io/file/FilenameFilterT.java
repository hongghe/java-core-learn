package org.javacore.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Jeff Lee
 * @since 2015-7-20 13:31:41
 * 类名过滤器的使用
 */
public class FilenameFilterT {

	public static void main(String[] args) {
		// IO包路径
		String dir = "src" + File.separator +
                "main" + File.separator + "java" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io";
		File file = new File(dir);
		// 创建过滤器文件
		MyFilter filter = new MyFilter("T.java");
		// 过滤
		String files[] = file.list(filter);

		// 打印
		for (String name : files) {
			System.err.println(name);
		}
	}

	/**
	 *	内部类实现过滤器文件接口
	 */
	static class MyFilter implements FilenameFilter {

		private String type;

		public MyFilter (String type) {
			this.type = type;
		}

		// 保留以type结尾的文件
		@Override
		public boolean accept(File dir, String name) {
			return name.endsWith(type);// 以Type结尾
		}

	}
}
