package org.javacore.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * @author Jeff Lee
 * @since 2015-7-31 11:04:26
 * 	System.out, System.err中IO的使用
 * 		替换系统流，输出至文本
 */
public class SystemStreamT {
	public static void main(String[] args) throws IOException {
		// 创建文件输出流
		OutputStream out = new FileOutputStream("D:\\data\\console.txt");
		// 创建新的文件输出打印流
		PrintStream print = new PrintStream(out);
		// 设置标准输出流
		System.setOut(print);
		// 设置标准错误输出流
		System.setErr(print);

		System.out.println("Hello,System.out");
		System.err.println("Hello,System.err");

		// 关闭流
		print.close();
		out.close();
	}
}
