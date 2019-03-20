package sf.wj.test.controller;

import org.junit.Test;
import sf.wj.annotation.NotNull;
import sf.wj.domain.vo.Person;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * Created by wangjun32 on 2018/9/20.
 */
public class PersonTest {
    @Test
    public void test1() {
        Person person = new Person();
        person.setName("wj");
        try {
//            Class<? extends BaseParam> clazz = param.getClass();
//            Class<?> superclazz = clazz.getSuperclass();
//            Field[] fields = clazz.getDeclaredFields();
//            Field[] superFields = superclazz.getDeclaredFields();
//            Field[] fieldAll = ArrayUtils.addAll(fields, superFields);
//            for (Field field : fieldAll) {
//                NotNull annotation = field.getAnnotation(NotNull.class);
//                if(annotation != null){
//                    field.setAccessible(true);
//                    if (field.get(param) == null) {
//                        throw new IllegalArgumentException(annotation.msg());
//                    }
//                }
//            }


            Objects.requireNonNull(person, "用户信息不能为空");
            for (Field field : Person.class.getDeclaredFields()) {
                NotNull annotation = field.getAnnotation(NotNull.class);
                if (!Objects.equals(annotation, null)) {
                    //对所有属性设置访问权限  当类中的成员变量为private时 必须设置此项
                    field.setAccessible(true);
                    if (Objects.equals(field.get(person), null)) {
                        throw new IllegalArgumentException(annotation.msg());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
