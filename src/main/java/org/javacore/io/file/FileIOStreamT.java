package org.javacore.io.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Jeff Lee
 * @since 2015-10-8 20:06:03
 * 文件流
 * FileInputStream&FileOutputStream使用案例
 */
public class FileIOStreamT {
	private static final String thisFilePath =
            "src" + File.separator + "main" + File.separator +
			"java" + File.separator +
			"org" + File.separator +
			"javacore" + File.separator +
			"io" + File.separator +  "file" + File.separator +
			"FileIOStreamT.java";
	public static void main(String[] args) throws IOException {
		// 创建文件输入流
		FileInputStream fileInputStream = new FileInputStream(thisFilePath);
		// 创建文件输出流, 如果是相对路径则是以项目跟路径为相对路径
		FileOutputStream fileOutputStream =  new FileOutputStream("E:" + File.separator + "data.txt");

		// 创建流的最大字节数组
		byte[] inOutBytes = new byte[fileInputStream.available()];
		// 将文件输入流读取，保存至inOutBytes数组
		fileInputStream.read(inOutBytes);
		// 将inOutBytes数组，写出到data.txt文件中
		fileOutputStream.write(inOutBytes);

		fileOutputStream.close();
		fileInputStream.close();
	}
}
