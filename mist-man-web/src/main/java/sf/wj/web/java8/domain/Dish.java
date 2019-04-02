package sf.wj.web.java8.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Created by wangjun32 on 2019/3/28.
 */
@Data
@ToString
public class Dish {
    private final String name;
    private final boolean vegetarian;
    private final int calories;
    private final Type type;

    public Dish(String name, boolean vegetarian, int calories, Type type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public enum Type { MEAT, FISH, OTHER }
}
