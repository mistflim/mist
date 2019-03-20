package sf.wj.reflect;

import sf.wj.Student;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by wangjun32 on 2019/3/14.
 */
public class ReflectTest {
    public static void main(String[] args){
        Class<Student> clazz = Student.class;
        for (Method method : clazz.getMethods()) {
            System.out.println( "方法："+method.getName());
        }
        for (Field field : clazz.getDeclaredFields()) {
            System.out.println("成员变量名字："+field.getName());
            System.out.println("成员变量类型："+field.getType());
        }
        try {
//            Object aaa = Class.forName("").newInstance();
            Student aa = clazz.newInstance();
            System.out.println(  aa.getClass());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
