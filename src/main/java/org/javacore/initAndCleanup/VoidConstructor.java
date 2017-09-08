package org.javacore.initAndCleanup;

/**
 * @author Jeff Lee
 * @since 2015-9-8 09:31:12
 * 默认构造函数和方法的区别
 */
public class VoidConstructor {


    // 构造函数不需要类型修饰，与类名相同即可
	VoidConstructor(){
		// this is a constructor
        System.out.println(getClass().getName() + "  init...");
    }

	void VoidConstructor() {
		// this is a method,not a constructor
        System.out.println("constructor is a function");
    }

    public static void main(String[] args) {
        VoidConstructor obj = new VoidConstructor();
        obj.VoidConstructor();
    }
}
