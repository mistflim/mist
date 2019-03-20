package sf.wj.suanfa;

/**
 * 兔子生小兔子算法
 * <p>
 * <p>
 * 从第一对兔子开始，第1个月1对兔子，由于“长到第三个月后每个月又生一对兔子”，
 * 所以第2个月也是1对兔子，第3个月时可以生一对兔子，所以总数为2对，
 * 这时，其中有一对是以后每个月都可以生一对兔子的老兔子，另一对是一对新兔子，它对有在第三个月的时候才可以每个月生一对兔子；
 * 这样的话，第4个月的兔子总数为3对，
 * …以此类推，从第1个月到第12个月的兔子总数分别为：1，1，2，3，5，8，13，21，34，55，89，144
 * f(n) = {n <=2, m=1
 * n>2,    m=f(n-1)+f(n-2)}
 */
public class Rabbit {

    private static int shengtuzi(int n) {
        if (n < 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        } else {
            return shengtuzi(n - 1) + shengtuzi(n - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(Rabbit.shengtuzi(6));
    }
}
