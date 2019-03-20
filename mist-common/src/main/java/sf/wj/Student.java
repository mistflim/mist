package sf.wj;

/**
 * Created by wangjun32 on 2019/3/14.
 */
public class Student {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void study(String name){
        System.out.println(name+"正在学习");
    }
}
