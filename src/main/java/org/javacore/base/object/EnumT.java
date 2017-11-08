package org.javacore.base.object;

/**
 * 枚举类的使用
 * @Author: HaoBin
 * @Date 2017/11/7 18:47
 */
// 常量用法
enum Color {
    RED, GREEN, BLANK, YELLOW
}

// 自定义枚举函数
enum ColorEnum {

    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);

    // 设置属性
    private String name;
    private int index;

    // 构造函数
    private ColorEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


}

// 测试类
public class EnumT {

    static boolean isRed(Color color) {
        if (Color.RED.equals(color)) {
            return true;
        }
        return false;
    }

    static void showColor(Color color) {
        switch (color) {
            case BLANK:
                System.out.println(color);
                break;
            case RED:
                System.out.println(color);
                break;
            default:
                System.out.println(color);
                break;
        }
    }

    public static void main(String[] args) {
        // 常量类型排序从0开始
        System.out.println(Color.RED.ordinal());
        System.out.println(isRed(Color.BLANK));  //结果： false
        System.out.println(isRed(Color.RED));    //结果： true

        showColor(Color.RED);

        //输出某一枚举的值
        System.out.println( ColorEnum.RED.getName() );
        System.out.println( ColorEnum.RED.getIndex() );

        //遍历所有的枚举
        for( ColorEnum color : ColorEnum.values()){
            System.out.println( color + "  name: " + color.getName() + "  index: " + color.getIndex() );
        }

    }
}
