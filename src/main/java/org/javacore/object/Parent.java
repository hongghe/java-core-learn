package org.javacore.object;

public class Parent {
    private String lastName;
    private char blood;

    protected String hobby;

    public int age;

    Parent(String lastName, char bloods) {
        this.lastName = lastName;
        blood = bloods;
    }

    Parent() {

    }

    public void setBlood(char blood) {
        this.blood = blood;
    }

    public char getBlood() {

        return blood;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getLastName() {

        return lastName;
    }

    public static void main(String[] args) {
        Parent obj1 = new Parent("hao", 'A');
        System.out.println(obj1.lastName + ":" + obj1.blood);
    }
}
