package org.javacore.io;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author Jeff Lee
 * @since 2015-7-14 08:54:24
 * 内存中输入
 */
public class MemoryInputT {
	public static void main(String[] args) throws IOException {
		StringReader in = new StringReader(BufferedInputFileT.read(
				"src" + File.separator +
				"org" + File.separator +
				"javacore" + File.separator +
				"io" + File.separator +
				"BufferedInputFileT.java"));
		int c;
		while((c = in.read()) != -1)// int形式
			System.out.println((char)c);// int字节，转char显示
	}
}
