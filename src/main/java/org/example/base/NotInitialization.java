package org.example.base;

/**
 *  @author: paladin
 *  @date: created in 2020/6/28 21:55
 */
class SSClass {
    static {
        System.out.println("SSClass");
    }
}

class SuperClass extends SSClass {
    static {
        System.out.println("SuperClass init");
    }

    public static int value = 123;

    public SuperClass() {
        System.out.println("init SuperClass");
    }
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass init");
    }

    static int a;

    public SubClass() {
        System.out.println("init Subclass");
    }
}

public class NotInitialization{
    public static void main(String[] args) {
        // 加载父类静态属性的时候，子类不需要被加载，所以不会执行子类的static代码块
        System.out.println(SubClass.value);
    }
}