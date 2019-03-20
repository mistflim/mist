package sf.wj.domain.single;

/**
 * Created by wangjun32 on 2019/3/1.
 */
public class Singleton3 {
    private static Singleton3 INSTANCE;
    private Singleton3(){
    }
    public static Singleton3 getIntstance(){
        if(null == INSTANCE){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }
}
