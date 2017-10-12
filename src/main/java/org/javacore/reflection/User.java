package org.javacore.reflection;
/**
 * @author Jeff Lee
 * @since 2015-9-8 09:35:14
 * 反射构造器使用的bean
 */
public class User {
	private int id;
	private String name;

	// 无参构造器（默认构造器）
	public User() {
	}

	public User(int id) {
		this.id = id;
	}

	public User(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + "]";
	}
}
