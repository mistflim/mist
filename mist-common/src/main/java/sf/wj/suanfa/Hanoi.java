package sf.wj.suanfa;

/**
 * 汉诺塔
 * 汉诺塔（Hanoi Tower），又称河内塔，源于印度一个古老传说。
 * 大梵天创造世界的时候做了三根金刚石柱子，在一根柱子上从下往上按照大小顺序摞着64片黄金圆盘。
 * 大梵天命令婆罗门把圆盘从下面开始按大小顺序重新摆放在另一根柱子上。并且规定，任何时候，在小圆盘上都不能放大圆盘，
 * 且在三根柱子之间一次只能移动一个圆盘。问应该如何操作？
 * <p>
 * 思路：
 * 1、将c作为辅助，将a上63个盘子移到b上
 * 2、将a上最后一个盘子放到c上
 * 3、将a作为辅助，把b上63个盘子放到c上
 * <p>
 * 4、将c作为辅助，将a上62个盘子移到b上
 * 5、将a上最后一个盘子放到c上
 * 6、将a作为辅助，把b上62个盘子放到c上
 * <p>
 * Created by wangjun32 on 2018/10/19.
 */
public class Hanoi {
    /**
     * 将n个盘子由a移动到c，b作为辅助
     *
     * @param n
     * @param a
     * @param b
     * @param c
     */
    private static void move(int n, String a, String b, String c) {
        if (n == 1) {
            System.out.println("移动盘子" + a + "--》" + c);
        }else{
            //将n-1个盘子由a借助c移动到b
            move(n - 1, a, c, b);
            System.out.println("移动盘子" + a + "--》" + c);
            move(n - 1, b, a, c);
        }
    }

    public static void main(String[] args) {
        move(3,"a","b","c");
    }
}
 