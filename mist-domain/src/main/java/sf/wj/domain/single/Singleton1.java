package sf.wj.domain.single;

/**
 * Created by wangjun32 on 2019/3/1.
 */
public class Singleton1 {
    public static final Singleton1 INSTANCE = new Singleton1();
    private Singleton1() {
    }

    private Singleton1(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
