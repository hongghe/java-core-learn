package org.javacore.initAndCleanup;
/**
 * @author Jeff Lee
 * @since 2015-9-7 16:54:19
 * 带参数简单构造器的展示
 */
public class SimpleConstructor2 {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Child2(i);
		}
	}
}

// Child类
class Child2 {
	Child2(int i) {// 带参数的Child类构造器
		System.out.print("Child init " + i + " ");
	}
}
