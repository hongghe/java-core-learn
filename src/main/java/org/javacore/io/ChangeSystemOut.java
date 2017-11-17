package org.javacore.io;

import java.io.PrintWriter;

/**
 * @author Jeff Lee
 * @since 2015-10-6 18:38:15
 * 改变System.out输出案例
 */
public class ChangeSystemOut {
	public static void main(String[] args) {
		PrintWriter out = new PrintWriter(System.out,true);
		out.println("Hello PrintWriter");
		out.close();
	}
}
