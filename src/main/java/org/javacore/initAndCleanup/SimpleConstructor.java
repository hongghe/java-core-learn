package org.javacore.initAndCleanup;

/**
 * @author Jeff Lee
 * @since 2015-9-7 16:54:19
 * 简单构造器的展示
 */
public class SimpleConstructor {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			new Child();
		}
	}
}

// Child类
class Child {
	Child() { // Child类的构造器
		System.out.print("Child init... ");
	}
}
