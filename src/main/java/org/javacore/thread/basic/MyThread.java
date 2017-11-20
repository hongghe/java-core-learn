package org.javacore.thread.basic;



/**
 * @author Jeff Lee
 * @since 2015-7-4 16:14:51
 * 	Thread的简单使用
 */
public class MyThread extends Thread{

	@Override
	public void run() {
		System.out.println("MyThread --> run()");
	}

}
