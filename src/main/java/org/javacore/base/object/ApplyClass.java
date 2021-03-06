package org.javacore.base.object;

import java.util.Arrays;

/**
 * 继承
 * getClass是获取运行时对象的类信息
 */
class Processor {
    public String name(){
        return getClass().getSimpleName();
    }
    Object process(Object input){return input;}
}

class Upcase extends Processor {
    @Override
    Object process(Object input) {
        return ((String)input).toUpperCase();
    }
}

class Splitcase extends Processor {
    @Override
    Object process(Object input) {
        return Arrays.toString(((String) input).split(" "));
    }
}

class dog {
    public String name;
    public int sex;
}

public class ApplyClass {
    public static void process(Processor p , Object input){
        System.out.println("调用对象名：" + p.name());
        System.out.println(p.process(input));
    }

    public static String s = "BYSocket's Blog is www.bysocket.com";
    public static void main(String[] args) {
        process(new Upcase(),s);
        process(new Splitcase(),s);
    }
}
