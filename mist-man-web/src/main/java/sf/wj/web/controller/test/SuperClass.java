package sf.wj.web.controller.test;

/**
 * @author wangjun32
 */
public class SuperClass {
    static {
        System.out.println("SuperClass Init !!!");
    }
    public static int value = 123;
}

class SubClass extends SuperClass{
    static {
        System.out.println("SubClass Init !!!");
    }
}

class ConstClass {
    static {
        System.out.println("ConstClass Init !!!");
    }
    public static final int value = 123;
}

class NotInitialization1 {
    public static void main(String[] args) {
        System.out.println(SubClass.value);
//        SuperClass[] superClasses = new SuperClass[10];
//        System.out.println(ConstClass.value);
    }
}