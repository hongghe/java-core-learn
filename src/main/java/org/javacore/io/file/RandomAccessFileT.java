package org.javacore.io.file;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * @author Jeff Lee
 * @since 2015-7-14 08:54:24
 * RandomAccessFile的使用
 */
public class RandomAccessFileT {
	public static void main(String[] args) throws IOException {
		// 获取文件，读写方式
		RandomAccessFile file = new RandomAccessFile("G:\\file.txt","rw");

		// 设置文件指针位置
		file.seek(6);
		// 文件中的当前偏移量
		System.out.println(file.getFilePointer());

		// 读取文本的一行
		System.out.println((char)file.read());// int字节，转char显示

		// 写入字节数组
		file.write("Hello World".getBytes());

		// 初始化文件指针位置
		file.seek(0);
		// 读取文本的一行
		System.out.println(file.readLine());

		file.close();
	}
}
