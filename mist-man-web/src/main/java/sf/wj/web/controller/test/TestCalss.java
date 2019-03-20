package sf.wj.web.controller.test;

/**
 * Created by wangjun32 on 2018/9/13.
 */

class Singleton{
    private static Singleton singleton = new Singleton();
    public static int value1, value2 = 0;
    public static final  int value3 = 3;
    private Singleton(){
        value1++;value2++;
    }
    static{
        System.out.println("111111");
    }
    public static Singleton getInstance(){
        return singleton;
    }
}

class Singleton2{
    public static int value1,value2 = 0;
    private static Singleton2 singleton2 = new Singleton2();
    private Singleton2(){
        value1++;value2++;
    }
    public static Singleton2 getInstance2(){
        return singleton2;
    }
}

public class TestCalss{
    public static void main(String[] args) {
//        Singleton singleton = Singleton.getInstance();
//        System.out.println("Singleton1 value1:" + singleton.value1);
//        System.out.println("Singleton1 value2:" + singleton.value2);
        System.out.println(Singleton.value3);
        Singleton2 singleton2 = Singleton2.getInstance2();
        System.out.println("Singleton2 value1:" + singleton2.value1);
        System.out.println("Singleton2 value2:" + singleton2.value2);
    }
}


