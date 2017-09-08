package org.javacore.reflection;


/**
 * @author Jeff Lee
 * @since 2015-11-9 10:45:19
 * 反射在继承中的案例
 */
class Employee {
    private String name;
    public Employee(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }
}
class Manager extends Employee {
    public Manager(String name) {
        super(name);
    }
}
public class EmployeeClass {
    public static void main(String[] args) throws Exception{
        Employee employee = new Employee("Jeff");
        Employee manager = new Manager("Boss");
        String className = employee.getClass().getName();
        Class cl = Class.forName(className);
        System.out.println(Employee.class);
        System.out.println(cl);
        System.out.println(employee.getClass().getName() + " " + employee.getName());
        System.out.println(manager.getClass().getName() + " " + manager.getName());
    }
}
