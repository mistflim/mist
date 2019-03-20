package sf.wj.reflect;

/**
 * Created by wangjun32 on 2019/3/15.
 */
public class Test {
    public static void main(String[] args){
        A a1 = new A();
        A a2 = new B();
        B b  = new B();
        C c = new C();
        
        System.out.println(a1.show(c));
        System.out.println(a2.show(c));
        System.out.println(a2.show(b));
        
        System.out.println(b.show(c));

    }

    static class A{
        public String show(A a){
            return "A A";
        }

        public String show(C c){
            return "A C";
        }
    }

    static class B extends A{
        public String show(B b){
            return "B B";
        }

        @Override
        public String show(C c){
            return "B C";
        }
    }

    static class C extends B{

    }
}
