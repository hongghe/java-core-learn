package org.javacore.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Jeff Lee
 * @since 2015-8-11 11:44:59
 * 文件复制
 * 通过文件输入输出流来完成复制
 */
public class CopyFileT {
	public static void main(String[] args) throws IOException {
		String dir = "src" + File.separator + "main" + File.separator + "java" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator + "file";

		copyFile(dir + File.separator + "/CopyFileT.java", "G://Copy.java");
	}

	public static void copyFile(String srcFile,String destFile)
		throws IOException {
		copyFile(new File(srcFile), new File(destFile));
	}

	public static void copyFile(File srcFile,File destFile)
		throws IOException {
		// 文件不存在
		if (!srcFile.exists()) {
			throw new IllegalArgumentException("文件：" + srcFile + "不存在");
		}
		// 文件不是文件类型
		if (!srcFile.isFile()) {
			throw new IllegalArgumentException(srcFile + "不是文件");
		}
		FileInputStream in = new FileInputStream(srcFile);
		FileOutputStream out = new FileOutputStream(destFile);
		byte[] bytes = new byte[2 * 1024];
		int b;
		// 一次读2K
		while ((b=in.read(bytes, 0, bytes.length)) != -1) {
			out.write(bytes, 0, b);
			out.flush();
		}
		out.close();
		in.close();
	}
}
