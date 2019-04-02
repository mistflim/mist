package sf.wj.web.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by wangjun32 on 2019/3/27.
 */
public class Test {
    public static void main(String[] args){
//        File[] files = new File(".").listFiles(file -> file.isHidden());
        Predicate<String> a = (String s) ->s.isEmpty();


        List<String> aa = filter(Arrays.asList("1", "", "3"), a);
        System.out.println(aa.size());
        Function<Integer, Integer> f = x -> x + 1;
       System.out.println(f.apply(1));

    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> results = new ArrayList<>();
        for(T s: list){
            if(p.test(s)){
                results.add(s);
            }
        }
        return results;
    }
}
