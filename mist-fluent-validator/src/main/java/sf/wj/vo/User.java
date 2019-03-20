package sf.wj.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class User implements Serializable{

    private static final long serialVersionUID = 227971143292920247L;
    private String name;

    private String sex;

    public User(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
