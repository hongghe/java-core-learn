package org.javacore.collection.map;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Jeff Lee
 * @since 2015-6-18 21:36:04
 * 	TreeMap 的使用
 * 	有序的（红黑树）
 */
public class TreeMapT
{
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args)
	{
		Map map = new TreeMap();
		map.put("1", "1");
		map.put("4", "4");
		map.put("2", "2");
		map.put("2", "3");
		// 注意排序
		System.out.println(map);
	}
}
