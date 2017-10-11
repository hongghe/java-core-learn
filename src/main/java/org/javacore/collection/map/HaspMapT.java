package org.javacore.collection.map;

import java.util.HashMap;
import java.util.Map;

public class HaspMapT{
	public static void main(String[] args)
	{
		objOper();
		nullOper();
	}

	/**
	 * HaspMap操作对象方法
	 */
	public static void objOper(){
		Map<String, Employee> employees = new HashMap<String, Employee>();

		String number = "1206010035";
		//设置对象
		employees.put(number, new Employee());
		// 获取对象
        System.out.println(employees);
	}

	/**
	 * HaspMap的put方法
	 */
	public static void nullOper(){
		Map map = new HashMap<String, String>();
		// 一个键只能有一个值
		map.put(null, "null01");
		map.put(null, "null02");
		System.out.println(map);
		System.out.println(map.get(null));
	}
}
class Employee
{}
