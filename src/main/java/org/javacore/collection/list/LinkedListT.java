package org.javacore.collection.list;

import java.util.List;
import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListT {
    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("aaa");
        a.add("aaa1");
        a.add("aaa2");


        List<String > b = new LinkedList<>();
        b.add("bbb");
        b.add("bbb1");
        b.add("bbb2");

        ListIterator<String> aIter = a.listIterator();

        ListIterator<String> bIter = b.listIterator();

        // add listB to ListA
        while (bIter.hasNext()) {
            if(aIter.hasNext())
                aIter.add(bIter.next());
        }

        System.out.println(a);
    }
}
