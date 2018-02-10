### comparable接口

可以直接使用java.util.Arrays类进行数组的排序操作，但对象所在的类必须实现Comparable接口，用于指定排序接口。

comparable接口定义：
``` 
public interface Comparable<T> {
    public int compareTo(T o);
}
```

compareTo返回一个int类型数据，int的值划分为：
- 1: 大于
- -1：小于
- 0：等于


### 比较器Comparator

如果一个类已经开放完成，但是在此类建立的初期并没有实现Comparable接口，此时肯定是无法进行对象排序操作的，所以为了解决这一的问题，java又定义了另一个比较器的操作接口 Comparator 此接口定义在java.util包中，接口定义如下：

``` 
public  interface  Comparator<T>{
     public  int  compare(T o1，T o2);
     boolean  equals(Object  obj);
}
```