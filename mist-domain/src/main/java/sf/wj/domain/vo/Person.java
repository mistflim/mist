package sf.wj.domain.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import sf.wj.annotation.NotNull;

import java.io.Serializable;

/**
 * Created by wangjun32 on 2018/9/20.
 */
@Setter
@Getter
@ToString
public class Person implements Serializable {
    private static final long serialVersionUID = -6793631313138635578L;
    @NotNull(msg = "姓名不能为空")
    private String name;

    private String sex;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }
}
