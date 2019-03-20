package sf.wj.domain.single;

import org.springframework.util.StringUtils;

/**
 * Created by wangjun32 on 2019/3/1.
 */
public class SingletonTest {
    public static void main(String[] args){
//        TestThread e = new TestThread();
//        e.run();
//        ThreadPoolExecutor a = new ThreadPoolExecutor(2,100,5,TimeUnit.SECONDS,new LinkedBlockingQueue());
//        for(int i=0;i<2;i++){
//            a.execute(new TestThread());
////            try {
//////                Thread.sleep(1000L);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
//        }
        
        String[] a1 = {"111","222"};
        System.out.println(StringUtils.arrayToCommaDelimitedString(a1));

    }

    static class TestThread implements Runnable{
        private Singleton3 s1;
        @Override
        public void run() {
            s1 = Singleton3.getIntstance();
            System.out.println(s1);
        }
       
    }
}
