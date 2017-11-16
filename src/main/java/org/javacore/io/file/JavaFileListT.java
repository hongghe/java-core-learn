package org.javacore.io.file;

import java.io.File;
import java.io.FilenameFilter;

/**
 * @author Jeff Lee
 * @since 2015-7-13 21:13:58
 * FilenameFilter文件过滤器的使用
 */
public class JavaFileListT {

	// 文件过滤接口
	// 作为匿名内部类，变量type必须声明为final类型
	public static FilenameFilter javaFileFilter(final String type) {
		// 过滤接口-匿名内部类
		return new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return new File(name).getName().indexOf(type) != -1;
			}
		};
	}

	public static void main(String[] args) {
		// 创建一个目录
		File file = new File("src\\main\\java\\org\\javacore\\io");// 当前目录
		// 获取文件名数组
		String fileNames[] = file.list(javaFileFilter(".java"));
		// 打印
		for (String item : fileNames) {
			System.out.println(item);
		}
	}
}
