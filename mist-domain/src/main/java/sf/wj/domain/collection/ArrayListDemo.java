package sf.wj.domain.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangjun32 on 2019/3/4.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
//        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,10,100, TimeUnit.SECONDS,new LinkedBlockingDeque<>());
//        for(int i=0;i<2;i++){
//            executor.execute(new aThread());
//        }
//        testC();

    }

    static class aThread implements Runnable{

        @Override
        public void run() {
            testC();
        }
    }

    public static void testC() {
        List<String> list = new ArrayList<>();
        list.add("张三111");
        list.add("李四1");
        list.add("wangwu111");
        list.add("zhaoliu");
        list.add("wangwu1");

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String e = iterator.next();
//            if ("李四1".equals(e)) {
//                iterator.remove();
//            }
//        }

        for (String s : list) {
            if ("李四1".equals(s)) {
                list.remove(s);
            }
        }
        System.out.println(list.size());
    }


}
