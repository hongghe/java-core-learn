package org.javacore.object;

public class ObjT {
    public enum Size {
        SMALL,MEDIUM,LARGE;
    }

    public static void main(String[] args) {
        ObjT obj = new ObjT();
        Size s = Enum.valueOf(Size.class, "SMALL");
        Size[] values = Size.values();
        for (Size item : values){
            System.out.println(item);
        }
    }
}
