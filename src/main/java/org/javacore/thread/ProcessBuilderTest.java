package org.javacore.thread;

import java.io.IOException;
import java.util.Scanner;

/**
 * Java进程调用CMD
 *  VM options => -Dfile.encoding="GBK"
 * @author BYSocket
 * @since 2016-01-18 16:08:00
 */
public class ProcessBuilderTest {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("cmd","/c","ipconfig/all");
        Process p = pb.start();

        Scanner scanner = new Scanner(p.getInputStream());
        while (scanner.hasNext())
            System.out.println(scanner.next());
        scanner.close();
    }
}
