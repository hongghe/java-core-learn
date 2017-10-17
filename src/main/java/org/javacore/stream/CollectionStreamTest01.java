package org.javacore.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Stream API 集合的流式操作
 * <p/>
 * Created by bysocket on 16/7/13.
 */
public class CollectionStreamTest01 {
    public static void main(String[] args) {
        List<String> strList = Arrays.asList("a1", "a2", "c3", "c6", "c4");

        strList
                .stream()
                .filter(str -> str.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);
    }
}
